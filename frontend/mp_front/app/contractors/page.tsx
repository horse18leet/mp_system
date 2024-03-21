"use client";

import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";

import { useEffect, useState } from "react";

import { IAddContractor, addContractorScheme } from "@/utils/schemas/contractor/add-contractor.scheme";

import { ColumnDef } from "@tanstack/react-table";
import { Checkbox } from "@/components/ui/checkbox";

import { DataTable } from "@/components/Table/data-table";
import { DataTableColumnHeader } from "../../components/Table/data-table-column-header";
import { DataTableRowActions } from "../../components/Table/data-table-row-actions";

import { useForm } from "react-hook-form";
import { Input } from "@/components/ui/input";
import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form";
import { joiResolver } from "@hookform/resolvers/joi";
import {
    Popover,
    PopoverContent,
    PopoverTrigger,
} from "@/components/ui/popover";
import {
    Command,
    CommandEmpty,
    CommandGroup,
    CommandInput,
    CommandItem,
} from "@/components/ui/command";
import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from "@/components/ui/dialog";
import { Check, ChevronsUpDown } from "lucide-react";
import { cn } from "@/lib/utils";
import { Textarea } from "@/components/ui/textarea";
import { Button } from "@/components/ui/button";
import { FacetedFilterOption } from "@/components/Table/types/data-table-types";

import { AxiosError } from "axios";
import { createContractor, getContractors } from "@/utils/api/services/contractor.service";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

export default function Contractors() {
    const [contractors, setContractors] = useState<IContractorResponse[]>([]);
    const [contractorTypes, setContractorTypes] = useState(["Поставщик", "Реклама", "Фулфилмент", "Байер"]);    //пока так
    const [dialogOpen, setDialogOpen] = useState(false);
    const [popoverOpen, setPopoverOpen] = useState(false);
    const [isOperationsDialogOpen, setIsOperationsDialogOpen] = useState(false);

    /*
    const rowActionsArr = [                 //массив действий со строками таблицы
    {
        title: "Операции",
    },
    {
      title: "Изменить",
    },
    {
      title: "Удалить",
    },
  ] as RowAction[];*/

    useEffect(() => {
        getAllContractors();
    }, []);

    function handleOperationsClick() {
        setIsOperationsDialogOpen(!isOperationsDialogOpen);
    }

    async function getAllContractors() {
        const contractors = await getContractors();
        setContractors(contractors);
    }

    async function addContractor(data: IAddContractor) {
        console.log("кнопка сабмита нажата...");

        const response = await createContractor(data);
    
        if (response instanceof AxiosError) {
          console.log(response.message);
          setDialogOpen(false);
          return;
        } else {
            getAllContractors().then(() => setDialogOpen(false));
        }
    }

    const columns: ColumnDef<IContractorResponse>[] = [
        {
            id: "select",
            header: ({ table }) => (
                <Checkbox
                    checked={
                        table.getIsAllPageRowsSelected() ||
                        (table.getIsSomePageRowsSelected() && "indeterminate")
                    }
                    onCheckedChange={(value) => table.toggleAllPageRowsSelected(!!value)}
                    aria-label="Select all"
                    className="translate-y-[2px]"
                />
            ),
            cell: ({ row }) => (
                <Checkbox
                    checked={row.getIsSelected()}
                    onCheckedChange={(value) => row.toggleSelected(!!value)}
                    aria-label="Select row"
                    className="translate-y-[2px]"
                />
            ),
            enableSorting: false,
            enableHiding: false,
        },
        {
            accessorKey: "id",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Подрядчик" />
            ),
            cell: ({ row }) => (
                <div className="w-[50px]">{"Подрядчик-" + row.getValue("id")}</div>
            ),
            enableSorting: false,
            enableHiding: false,
        },
        {
            accessorKey: "name",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Название" />
            ),
            cell: ({ row }) => {
                return (
                    <div className="flex space-x-2">
                        <span className="max-w-[100px] truncate font-medium">
                            {row.getValue("name")}
                        </span>
                </div>
                );
            },
            meta: {
                filterDisplayName: "Название",
            },
        },
        {
            accessorKey: "description",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Описание" />
            ),
            cell: ({ row }) => {
                return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("description")}
                    </span>
                </div>
                );
            },
            meta: {
                filterDisplayName: "Описание",
            },
        },
        {
            accessorKey: "type",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Вид" />
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
                filterDisplayName: "Вид",
            },
        },
        {
            accessorKey: "phoneNumber",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Телефон" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("phoneNumber") ? row.getValue("contractorPhoneNum") : "Не указано"}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Телефон",
            },
    
        },
        /*
        {
            accessorKey: "email",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="E-mail" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("email") ? row.getValue("email") : "Не указано"}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "E-mail",
            },
    
        }, */
        {
            accessorKey: "actualAddress",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Адрес" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("actualAddress")}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Адрес",
            },
    
        },
        {
            accessorKey: "cardNum",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Карта" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("cardNum")}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Карта",
            },
    
        },
        /**
        {
            accessorKey: "isActive",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Активен" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("isActive")}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Активен",
            },
    
        }, 
        {
            accessorKey: "createdAt",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Дата добавления" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("createdAt")}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Дата добавления",
            },
    
        },*/
        {
            id: "actions",
            cell: ({ row }) => (
                <DataTableRowActions
                row={row}
                onOperations={handleOperationsClick}
            //   onDelete={() => removeItem(row.original.id)}      //надо написать запросы к серваку
                />
            ),
        },
    ];

    const addContractorForm = useForm<IAddContractor>({
        resolver: joiResolver(addContractorScheme),
        
    });

    const additionalFilters = [
        {
            label: "Шаблоны",
            value: "Шаблоны",
        },
        {
            label: "Импорт",
            value: "Импорт",
        },
        {
            label: "Все",
            value: "Все",
        } 
    ] as  FacetedFilterOption[];
    
    return (
        <ProtectedLayout>
            <div className="container pt-8 h-full">
                <div className="flex-col space-y-8 md:flex hidden">
                    <Dialog open={isOperationsDialogOpen} onOpenChange={setIsOperationsDialogOpen}>
                        <DialogContent>
                            <div className="flex flex-col justify-between w-[300px] h-[500px]">
                                <DialogHeader>
                                    <DialogTitle>Операции</DialogTitle>
                                </DialogHeader>
                            </div>
                        </DialogContent>
                    </Dialog>

                    <Dialog open={dialogOpen} onOpenChange={setDialogOpen}>
                        <div className="flex items-center justify-between">
                            <div>
                                <h2 className="text-2xl font-bold tracking-tight">Список подрядчиков</h2>
                                <p className="text-muted-foreground">Добавьте новых подрядчиков</p>
                            </div>
                            <DialogTrigger asChild>
                                <Button variant="default" className="px-4 py-2 h-9">Добавить подрядчика</Button>
                            </DialogTrigger>
                        </div>
                        <DialogContent>
                            <DialogHeader>
                                <DialogTitle>Добавить</DialogTitle>
                                <DialogDescription>Заполните все обязательные поля, чтобы добавить подрядчика</DialogDescription>
                            </DialogHeader>
                            <Form {...addContractorForm}>
                                <form 
                                    className="flex flex-col gap-4" 
                                    onSubmit={addContractorForm.handleSubmit(addContractor)}
                                >
                                    <FormField
                                        control={addContractorForm.control}
                                        name="name"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Название</FormLabel>
                                                <FormControl>
                                                    <Input placeholder="Введите название..." {...field} />
                                                </FormControl>
                                                <FormDescription />
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={addContractorForm.control}
                                        name="type"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem className="flex flex-col">
                                                <FormLabel>Категория</FormLabel>
                                                <Popover open={popoverOpen} onOpenChange={setPopoverOpen}>
                                                    <PopoverTrigger asChild>
                                                        <FormControl>
                                                            <Button
                                                                variant="outline"
                                                                role="combobox"
                                                                className={cn("justify-between", !field.value && "text-muted-foreground")}
                                                            >
                                                            {field.value
                                                            ? contractorTypes.find(
                                                                (contractorType) =>
                                                                contractorType === field.value
                                                            )
                                                            : "Выберите категорию подрядчика"}
                                                                <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
                                                            </Button>
                                                        </FormControl>
                                                    </PopoverTrigger>
                                                        <PopoverContent className="w-[var(--radix-popover-trigger-width)] max-h-[var(--radix-popover-content-available-height)] p-0">
                                                        <Command>
                                                            <CommandInput
                                                                className="border-none focus-visible:ring-ring focus-visible:ring-offset-2"
                                                                placeholder="Поиск категории..."
                                                            />
                                                            <CommandEmpty>Категория не найдена.</CommandEmpty>
                                                            <CommandGroup>
                                                                {contractorTypes.map((contractorType) => (
                                                                <CommandItem
                                                                    value={contractorType}
                                                                    key={contractorType}
                                                                    onSelect={() => {
                                                                    addContractorForm.setValue("type",contractorType);
                                                                    setPopoverOpen(false);
                                                                }}
                                                                >
                                                                    <Check className={cn("mr-2 h-4 w-4", contractorType === field.value ? "opacity-100" : "opacity-0")} />
                                                                    {contractorType}
                                                                </CommandItem>
                                                                ))}
                                                            </CommandGroup>
                                                        </Command>
                                                        </PopoverContent>
                                                </Popover>
                                            </FormItem>
                                        )}
                                    />
                                    <div className="grid grid-cols-2 gap-4">
                                        <FormField
                                            control={addContractorForm.control}
                                            name="email"
                                            defaultValue=""
                                            render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>E-mail</FormLabel>
                                                <FormControl>
                                                    <Input {...field} />
                                                </FormControl>
                                            </FormItem>
                                            )}
                                        />
                                        {/* <FormField
                                            control={addContractorForm.control}
                                            name="phoneNum"
                                            render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Номер телефона</FormLabel>
                                                <FormControl>
                                                    <Input {...field} />
                                                </FormControl>
                                            </FormItem>
                                            )}
                                        /> */}
                                    </div>
                                    <FormField
                                        control={addContractorForm.control}
                                        name="description"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Описание</FormLabel>
                                                <FormControl>
                                                    <Textarea placeholder="Напишите описание подрядчика..." {...field} />
                                                </FormControl>
                                             </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={addContractorForm.control}
                                        name="actualAddress"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Адрес подрядчика</FormLabel>
                                                <FormControl>
                                                    <Input placeholder="Введите адрес..." {...field} />
                                                </FormControl>
                                                <FormDescription />
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                    <FormField
                                        control={addContractorForm.control}
                                        name="cardNum"
                                        defaultValue=""
                                        render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Платежные данные</FormLabel>
                                                <FormControl>
                                                    <Input placeholder="Введите номер карты..." {...field} />
                                                </FormControl>
                                                <FormDescription />
                                                <FormMessage />
                                            </FormItem>
                                        )}
                                    />
                                    <Button type="submit">Добавить</Button>
                                </form>
                            </Form>
                        </DialogContent>
                    </Dialog>
                <DataTable title="name" data={contractors} columns={columns} additionalFilters={additionalFilters} />
            </div>
        </div>
    </ProtectedLayout>
    );
}   