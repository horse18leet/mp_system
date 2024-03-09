"use client";

import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";

import { useState } from "react";

import { IAddContractor, addContractorScheme } from "@/utils/schemas/contractor/add-contractor.scheme";

import IItemResponse from "@/utils/models/item/item-response";
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
import { controllers } from "chart.js";

export default function Contractors() {
    // const [contractors, SetContractors] = useState<IItemResponse[]>([]);

    const [items, setItems] = useState<IItemResponse[]>([]); //пока  так
    const [contractors, SetContractors] = useState(["Поставщик", "Рекламный агент", "Фулфилмент", "Байер"]);    //пока так
    const [dialogOpen, setDialogOpen] = useState(false);
    const [popoverOpen, setPopoverOpen] = useState(false);

    const columns: ColumnDef<IItemResponse>[] = [
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
            accessorKey: "contractorId",
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
            accessorKey: "contractorTitle",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title={`Название/Имя подрядчика`}  />
            ),
            cell: ({ row }) => {
                return (
                    <div className="flex space-x-2">
                        <span className="max-w-[100px] truncate font-medium">
                            {row.getValue("title")}
                        </span>
                </div>
                );
            },
            meta: {
                filterDisplayName: "Название",
            },
        },
        {
            accessorKey: "contractorDescription",
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
            accessorKey: "contractorType",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Вид подрядчика" />
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
                filterDisplayName: "Вид подрядчика",
            },
        },
        {
            accessorKey: "contractorPhoneNumber",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Номер телефона" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("type") ? row.getValue("type") : "Не указано"}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Номер телефона",
            },
    
        },
        {
            accessorKey: "contractorEmail",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="E-mail" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("type") ? row.getValue("type") : "Не указано"}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "E-mail",
            },
    
        },
        {
            accessorKey: "contractorAdress",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Адрес" />
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
                filterDisplayName: "Адрес",
            },
    
        },
        {
            accessorKey: "contractorCardNumber",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Номер карты" />
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
                filterDisplayName: "Номер карты",
            },
    
        },
        {
            accessorKey: "contractorIsActive",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Активен" />
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
                filterDisplayName: "Активен",
            },
    
        },
        {
            accessorKey: "contractorCreatedAt",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Дата добавления" />
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
                filterDisplayName: "Дата добавления",
            },
    
        },
        {
            id: "actions",
            cell: ({ row }) => (
                <DataTableRowActions
                row={row}
            //   onDelete={() => removeItem(row.original.id)}      //надо написать запросы к серваку
                />
            ),
        },
    ];

    const addContractorForm = useForm<IAddContractor>({
        resolver: joiResolver(addContractorScheme),
    });
    return (
        <ProtectedLayout>
            <div className="container pt-8 h-full">
                <div className="flex-col space-y-8 md:flex hidden">
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
                            {/* onSubmit={addContractorForm.handleSubmit(addContractor)} */}
                                <form className="flex flex-col gap-4" >
                                    <FormField
                                        control={addContractorForm.control}
                                        name="name"
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
                                                            ? contractors.find(
                                                                (contractor) =>
                                                                contractor === field.value
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
                                                                {contractors.map((contractor) => (
                                                                <CommandItem
                                                                    value={contractor}
                                                                    key={contractor}
                                                                    onSelect={() => {
                                                                    addContractorForm.setValue("type",contractor);
                                                                    setPopoverOpen(false);
                                                                }}
                                                                >
                                                                    <Check className={cn("mr-2 h-4 w-4", contractor === field.value ? "opacity-100" : "opacity-0")} />
                                                                    {contractor}
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
                                            render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>E-mail</FormLabel>
                                                <FormControl>
                                                    <Input {...field} />
                                                </FormControl>
                                            </FormItem>
                                            )}
                                        />
                                        <FormField
                                            control={addContractorForm.control}
                                            name="phoneNumber"
                                            render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Номер телефона</FormLabel>
                                                <FormControl>
                                                    <Input {...field} />
                                                </FormControl>
                                            </FormItem>
                                            )}
                                        />
                                    </div>
                                    <FormField
                                        control={addContractorForm.control}
                                        name="description"
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
                                        name="actualAdress"
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
                                        name="cardNumber"
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
                <DataTable data={items} columns={columns} />
            </div>
        </div>
    </ProtectedLayout>
    );
}   