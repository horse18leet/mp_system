import { useState, useEffect } from "react";
import { useForm } from "react-hook-form";

import { joiResolver } from "@hookform/resolvers/joi";

import { ru } from 'date-fns/locale';

import { Button } from "../ui/button";

import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from "@/components/ui/dialog";

import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form";

import {
    Command,
    CommandEmpty,
    CommandGroup,
    CommandInput,
    CommandItem,
} from "@/components/ui/command";               //todo: toast

import {
    Popover,
    PopoverContent,
    PopoverTrigger,
} from "@/components/ui/popover";

import {
    Tooltip,
    TooltipContent,
    TooltipProvider,
    TooltipTrigger,
} from "@/components/ui/tooltip";

import { DataTableColumnHeader } from "../../components/Table/data-table-column-header";
import { DataTableRowActions } from "../../components/Table/data-table-row-actions";
import { DataTable } from "@/components/Table/data-table";
import { ColumnDef } from "@tanstack/react-table";

import { 
    Check,
    ChevronsUpDown,
} from "lucide-react";
import { 
    CalendarIcon, 
    ChevronRightIcon, 
    ChevronLeftIcon ,
} from '@radix-ui/react-icons'

import { Input } from "../ui/input";
import { Calendar } from "@/components/ui/calendar"

import { cn } from "@/lib/utils";
import { format } from "date-fns"

import { PurchaseProps } from "./types/purchase-types";

import { getContractors } from "@/utils/api/services/contractor.service";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

import { IAddPurchase, addPurchaseScheme } from "@/utils/schemas/purchase/add-purchase.scheme";
import IPurchaseRequest from "@/utils/models/purchase/purchase-request";
import IItemResponse from "@/utils/models/item/item-response";
import { IPurchaseContractor } from "@/utils/schemas/purchase/purchase-contractor/purchase-contractor.scheme";
import { createPurchase } from "@/utils/api/services/purchase.service";
import { AxiosError } from "axios";
import { formatDate } from "@/utils/utils";

import { useToast } from "@/components/ui/use-toast";


export default function Purchase({
    isOpen, 
    setIsOpen,
    itemsList,
}: PurchaseProps) {

    const [currentIndex, setCurrentIndex] = useState(0);
    const [currentItem, setCurrentItem] = useState<IItemResponse>(itemsList[0]);
    const [tempPurchaseId, setTempPurchaseId] = useState(null);
    const [isPopoverOpen, setIsPopoverOpen] = useState(false);  
    const [contractorsArr, setContractorsArr] = useState<IContractorResponse[]>([]);
    const [tableItems, setTableItems] = useState<any>([]);

    const [isNextButtonDisabled, setIsNextButtonDisabled] = useState(itemsList.length == 1 ? true : false);
    const [isPreviousButtonDisabled, setIsPreviousButtonDisabled] = useState(true);

    const purchaseForm = useForm<IAddPurchase>({
        resolver: joiResolver(addPurchaseScheme),
    });

    const { toast } = useToast();

    const columns: ColumnDef<IItemResponse>[] = [
       /* {
          accessorKey: "id",
          header: ({ column }) => (
            <DataTableColumnHeader column={column} title="Наименование" />
          ),
          cell: ({ row }) => (
            <div className="w-[80px]">{"ТОВАР-" + row.getValue("id")}</div>
          ),
          enableSorting: false,
          enableHiding: false,
        },*/
        {
          accessorKey: "contractor",
          header: ({ column }) => (
            <DataTableColumnHeader column={column} title="Наименование" />
          ),
          cell: ({ row }) => {
            return (
              <div className="flex space-x-2">
                <span className="max-w-[100px] truncate font-medium">
                  {row.getValue("contractor")}
                </span>
              </div>
            );
          },
          meta: {
            filterDisplayName: "Наименование",
          },
        },
        {
          accessorKey: "type",
          header: ({ column }) => (
            <DataTableColumnHeader column={column} title="Тип" />
          ),
          cell: ({ row }) => {
            return (
              <div className="flex space-x-2">
                <span className="max-w-[100px] truncate font-medium">
                  {row.getValue("type")}
                </span>
              </div>
            );
          },
          meta: {
            filterDisplayName: "Тип",
          },
        },
        {
          accessorKey: "cost",
          header: ({ column }) => (
            <DataTableColumnHeader column={column} title="Стоимость" />
          ),
          cell: ({ row }) => {
            return (
              <div className="flex space-x-2">
                <span className="max-w-[100px] truncate font-medium">
                  {row.getValue("cost")}
                </span>
              </div>
            );
          },
          meta: {
            filterDisplayName: "Стоимость",
          },
        },
        {
            accessorKey: "deadline",
            header: ({ column }) => (
              <DataTableColumnHeader column={column} title="Дата окончания работ" />
            ),
            cell: ({ row }) => {
              return (
                <div className="flex space-x-2">
                  <span className="max-w-[100px] truncate font-medium">
                    {
                        changeTableDate(row.getValue("deadline"))
                    }
                  </span>
                </div>
              );
            },
            meta: {
              filterDisplayName: "Дата окончания работ",
            },
        },
        /*
        {
          id: "actions",
          cell: ({ row }) => (
            <DataTableRowActions
              row={row}
              rowId={row.original.id}
              isOperations={false}
            //   onDelete={() => removeItem(row.original.id)}
            //   onUpdate={returnUpdateForm}
            />
          ),
        },*/
      ];

    useEffect(() => {
        getAllContractors();
    }, []);
    

    async function getAllContractors() {                  //получение всех подрядчиков
        const contractors = await getContractors();
        setContractorsArr(contractors);
    }

    function changeTableDate(tableDateValue: any) {
        const dateObject = new Date(tableDateValue);
        const dateString = formatDate(dateObject, false);
        return dateString;
    }

    async function addPurchase() {                              //отправка запроса на создание purchase на сервер
        const finalData = createPurchaseObj();
        const response = await createPurchase(finalData);

        if (response instanceof AxiosError) {
            // console.log("ошибка: ", response.message);
            toast({
                variant: "destructive",
                title: "Ошибка",
                description: response.message,
            });
            return;
        } else {
            // console.log(response);
            if (response.id) {
                if (tempPurchaseId === null) {
                    setTempPurchaseId(response.id);
                }
            }
            toast({
                title: "Закуп создан",
            });
        }
    }

    function createPurchaseObj() {    
        const reqContractorArr = JSON.parse(JSON.stringify(tableItems));
        reqContractorArr.forEach((item: any) => {
            delete item["quantity"];
            delete item["type"];
            const contractor = contractorsArr.find(contractor => contractor.name === item.contractor);
            item["contractorId"] = contractor?.id;
            delete item["contractor"];
            const dateObject = new Date(tableItems[0]["deadline"]);
            const newDate = formatDate(dateObject, true);
            item["deadline"] = newDate;
        });

        const finalData = {
            itemId: currentItem.id,
            quantity: tableItems[0]["quantity"] as number,
            contractorsWork: reqContractorArr,
        } as IPurchaseRequest;

        if (tempPurchaseId) {
            finalData["purchaseId"] = tempPurchaseId;
        }
        return finalData;
    }

    function addContractorToTable(data: any) {                              //добавление полей формы в таблицу
        const contractor = contractorsArr.find(contractor => contractor.name === data.contractor);
        const contractorType = contractor ? contractor["type"] : "";
        data["type"] = contractorType;

        setTableItems([...tableItems, data]);
    }
    
    function handleNextItem() {                                     //обработчик нажатия на кнопку следующего товара
        if (currentIndex === 0) {
            setIsPreviousButtonDisabled(false);
        } 
        if (currentIndex < itemsList.length - 1) {
            setCurrentIndex(currentIndex + 1);
            setCurrentItem(itemsList[currentIndex + 1]);
        }
        if (currentIndex === (itemsList.length - 2)) {
            setIsNextButtonDisabled(true);
        }
        setTableItems([]);
        purchaseForm.reset();

    }

    function handlePreviousItem() {                                     //обработчик нажатия на кнопку предыдущего товара
        if (currentIndex === itemsList.length - 1) {
            setIsNextButtonDisabled(false);
        }
        if (currentIndex > 0) {
            setCurrentIndex(currentIndex - 1);
            setCurrentItem(itemsList[currentIndex - 1]);
        }
        if (currentIndex === 1) {
            setIsPreviousButtonDisabled(true);
        }
        setTableItems([]);
        purchaseForm.reset();

    }

    return (
        <>
        <Dialog open={isOpen} onOpenChange={setIsOpen}>
            <DialogContent className="max-w-[1000px]">
                <DialogHeader className="mx-auto flex flex-row items-center mb-[30px]">
                    <TooltipProvider>
                        <Tooltip>
                            <TooltipTrigger asChild>
                                <Button variant="outline" size="icon" disabled={isPreviousButtonDisabled} className="mt-[6px]" onClick={handlePreviousItem}>
                                    <ChevronLeftIcon className="h-4 w-4" />
                                </Button>
                            </TooltipTrigger>
                            <TooltipContent side="bottom">
                                <p>Предыдущий товар</p>
                            </TooltipContent>
                        </Tooltip>
                        <DialogTitle className="mx-[20px] mb-[30px] text-2xl max-w-[400px] text-center break-words">{currentItem ? currentItem.title : "Товары не выбраны"}</DialogTitle>
                        <Tooltip>
                            <TooltipTrigger asChild>
                                <Button variant="outline" size="icon" disabled={isNextButtonDisabled} onClick={handleNextItem}>
                                    <ChevronRightIcon className="h-4 w-4" />
                                </Button>
                            </TooltipTrigger>
                            <TooltipContent side="bottom">
                                <p>Следующий товар</p>
                            </TooltipContent>
                        </Tooltip>
                    </TooltipProvider>
                </DialogHeader>
                    <div className="flex flex-row justify-between">
                        <Form {...purchaseForm}>
                            <form 
                                className="flex flex-col gap-4 h-[438px]" 
                                onSubmit={purchaseForm.handleSubmit(addContractorToTable)}
                            >
                                <div className="flex flex-col gap-y-[30px]">
                                    <FormField
                                        control={purchaseForm.control}
                                        name="quantity"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Количество закупаемого товара</FormLabel>
                                                <FormControl>
                                                    <Input {...field} className="w-[200px]"/>
                                                </FormControl>
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={purchaseForm.control}
                                        name="contractor"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem className="flex flex-col w-[200px]">
                                                <FormLabel>Подрядчик</FormLabel>
                                                <Popover open={isPopoverOpen} onOpenChange={setIsPopoverOpen}>
                                                    <PopoverTrigger asChild>
                                                        <FormControl>
                                                            <Button
                                                                variant="outline"
                                                                role="combobox"
                                                                className={cn("justify-between", !field.value && "text-muted-foreground")}
                                                            >
                                                                {field.value
                                                                ? contractorsArr.find(
                                                                    (contractor) =>
                                                                        contractor.name === field.value
                                                                )?.name
                                                                : "Выбрать подрядчика"}
                                                                <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
                                                            </Button>
                                                        </FormControl>
                                                    </PopoverTrigger>
                                                    <PopoverContent className="w-[var(--radix-popover-trigger-width)] max-h-[var(--radix-popover-content-available-height)] p-0">
                                                        <Command>
                                                            <CommandInput
                                                                className="border-none focus-visible:ring-ring focus-visible:ring-offset-2"
                                                                placeholder="Поиск подрядчика..."
                                                            />
                                                            <CommandEmpty>Подрядчик не найден.</CommandEmpty>
                                                            <CommandGroup>
                                                                {contractorsArr.map((contractor) => (
                                                                <CommandItem
                                                                    value={contractor.name}
                                                                    key={contractor.name}
                                                                    onSelect={() => {
                                                                        purchaseForm.setValue("contractor", contractor.name);
                                                                        setIsPopoverOpen(false);
                                                                    }}
                                                                >
                                                                    <Check className={cn("mr-2 h-4 w-4", contractor.name === field.value ? "opacity-100" : "opacity-0")} />
                                                                    {contractor.name}
                                                                </CommandItem>
                                                                ))}
                                                            </CommandGroup>
                                                        </Command>
                                                    </PopoverContent>
                                                </Popover>
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={purchaseForm.control}
                                        name="cost"
                                        defaultValue={0}
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Стоимость</FormLabel>
                                                <FormControl>
                                                    <Input  {...field} className="w-[200px]"/>
                                                </FormControl>
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={purchaseForm.control}
                                        name="deadline"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem>
                                                <div className="flex flex-col">
                                                    <FormLabel>Дата окончания работ</FormLabel>
                                                    <Popover>
                                                        <PopoverTrigger asChild>
                                                            <FormControl>
                                                                <Button
                                                                    variant={"outline"}
                                                                    className={cn("w-[200px] justify-start text-left font-normal mt-[12px]", !field.value && "text-muted-foreground")}
                                                                >
                                                                    <CalendarIcon className="mr-2 h-4 w-4" />
                                                                    {field.value ? format(field.value, "PPP") : <span>Выбрать дату</span>}
                                                                </Button>
                                                            </FormControl>
                                                        </PopoverTrigger>
                                                        <PopoverContent className="w-auto p-0" align="start">
                                                            <Calendar
                                                                mode="single"
                                                                selected={field.value}
                                                                onSelect={field.onChange}
                                                                initialFocus
                                                                locale={ru}
                                                            />
                                                        </PopoverContent>
                                                    </Popover>
                                                </div>
                                            </FormItem>
                                        )}
                                    />
                                    <Button type="submit" variant="secondary" className="w-[200px]">Добавить в таблицу</Button>
                                </div>
                            </form>
                        </Form>
                        <div className="flex flex-col justify-between h-[438px]">
                            <div className="max-h-[368px] overflow-auto">
                                <DataTable title="contractor" data={tableItems} columns={columns} isToolbar={false} isTablePagination={false} />
                            </div>
                            <Button className="w-[200px] self-end" disabled={tableItems.length > 0 ? false : true} onClick={addPurchase}>Добавить в закуп</Button>
                        </div>
                        
                    </div>           
            </DialogContent>
        </Dialog>
        
        </>
    );
} 