import { useState, useEffect } from "react";
import { useForm } from "react-hook-form";

import { joiResolver } from "@hookform/resolvers/joi";

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
} from "@/components/ui/command";

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

import { 
    Check,
    ChevronsUpDown,
} from "lucide-react";
import { CalendarIcon, ChevronRightIcon, ChevronLeftIcon } from '@radix-ui/react-icons'

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

export default function Purchase({
    isOpen, 
    setIsOpen,
    itemsList,
}: PurchaseProps) {

    const [currentIndex, setCurrentIndex] = useState(0);
    const [currentItem, setCurrentItem] = useState<IItemResponse>(itemsList[0]);
    const [currentContractorId, setCurrentContractorId] = useState(0);
    const [tempPurchaseId, setTempPurchaseId] = useState(null);
    const [errMessage, setErrMessage] = useState("Товары не выбраны");
    const [isPopoverOpen, setIsPopoverOpen] = useState(false);  
    const [contractorsArr, setContractorsArr] = useState<IContractorResponse[]>([]);

    const[isNextButtonDisabled, setIsNextButtonDisabled] = useState(itemsList.length == 1 ? true : false);
    const[isPreviousButtonDisabled, setIsPreviousButtonDisabled] = useState(true);

    const purchaseForm = useForm<IAddPurchase>({
        resolver: joiResolver(addPurchaseScheme),
    });

    useEffect(() => {
        getAllContractors();
    }, []);
    

    async function getAllContractors() {                  //получение всех подрядчиков
        const contractors = await getContractors();
        setContractorsArr(contractors);
    }

    async function addPurchase(data: any) {
        const finalData = createPurchaseObj(data);

        const response = await createPurchase(finalData);

        if (response instanceof AxiosError) {
            console.log("ошибка: ", response.message);
            return;
        } else {
            if (response.id) {
                if (tempPurchaseId === null) {
                    setTempPurchaseId(response.id);
                }
            }
        }
    }

    function createPurchaseObj(tempData: any) {           //временно
        

        const finalData = {
            itemId: currentItem.id,
            quantity: tempData["quantity"] as number,
            contractorsWork: [
                {
                    contractorId: currentContractorId,
                    cost: tempData["cost"],
                    deadline: tempData["deadline"],
                } as IPurchaseContractor,
            ],
        } as IPurchaseRequest;

        if (tempPurchaseId) {
            finalData["purchaseId"] = tempPurchaseId;
        }
        return finalData;
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
    }


    return (
        <Dialog open={isOpen} onOpenChange={setIsOpen}>
            <DialogContent className="max-w-[500px]">
                <DialogHeader className="mx-auto flex flex-row items-center">
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
                        <DialogTitle className="mx-[20px] mb-[30px] text-2xl max-w-[200px] text-center break-words">{currentItem ? currentItem.title : errMessage}</DialogTitle>
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
                    <Form {...purchaseForm}>
                        <form 
                            className="flex flex-col gap-4 " 
                            onSubmit={purchaseForm.handleSubmit(addPurchase)}
                        >
                            <div className="flex flex-col mb-[50px] gap-y-[30px]">
                                <FormField
                                    control={purchaseForm.control}
                                    name="quantity"
                                    defaultValue=""
                                    render={({ field }) => (
                                        <FormItem>
                                            <FormLabel>Количество закупаемого товара</FormLabel>
                                            <FormControl>
                                                <Input {...field} className="w-[100px]"/>
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
                                                                    setCurrentContractorId(contractor.id);
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
                                                <Input  {...field} className="w-[100px]"/>
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
                                                                    className={cn("w-[240px] justify-start text-left font-normal mt-[12px]", !field.value && "text-muted-foreground")}
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
                                                            />
                                                        </PopoverContent>
                                                    </Popover>
                                            </div>
                                        </FormItem>
                                    )}
                                />
                            </div>
                            <Button type="submit" className="w-[200px]">Добавить подрядчика</Button>
                        </form>
                    </Form>
                    {/* <DialogDescription>{errMessage}</DialogDescription> */}
            </DialogContent>
        </Dialog>
    );
} 