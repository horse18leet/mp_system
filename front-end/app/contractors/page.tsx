"use client";

import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";

import { ReactNode, useEffect, useState } from "react";

import { IAddContractor } from "@/utils/schemas/contractor/add-contractor.scheme";

import { ColumnDef } from "@tanstack/react-table";
import { Checkbox } from "@/components/ui/checkbox";

import { DataTable } from "@/components/Table/data-table";
import { DataTableColumnHeader } from "../../components/Table/data-table-column-header";
import { DataTableRowActions } from "../../components/Table/data-table-row-actions";

import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from "@/components/ui/dialog";

import { Button } from "@/components/ui/button";
import { FacetedFilterOption } from "@/components/Table/types/data-table-types";

import { AxiosError } from "axios";
import { createContractor, deleteContractor, editContractor, getContractors } from "@/utils/api/services/contractor.service";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

import ContractorForm from "@/components/CustomForms/ContractorForm/ContractorForm";
import { IEditContractor } from "@/utils/schemas/contractor/edit-contractor.sheme";
<<<<<<< Updated upstream
=======

import { useToast } from "@/components/ui/use-toast";
>>>>>>> Stashed changes

export default function Contractors() {
    const [contractors, setContractors] = useState<IContractorResponse[]>([]);
    const [isAddDialogOpen, setIsAddDialogOpen] = useState(false);
    const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);
<<<<<<< Updated upstream
=======
    const { toast } = useToast();
>>>>>>> Stashed changes

    useEffect(() => {
        getAllContractors();
    }, []);

    function returnUpdateForm(data: any): ReactNode {                          //возвращаем разметку, которую вставим в Dialog
        const contractor = data.original;
        return (
            <DialogContent>
                <DialogHeader>
                    <DialogTitle>Изменить данные подрядчика</DialogTitle>
                </DialogHeader>
                <ContractorForm handleFormSubmit={editContractorInfo} isEdit={true} contractor={contractor}/>
            </DialogContent>
        );
    }

    async function getAllContractors() {                        
        const contractors = await getContractors();
        setContractors(contractors);
    }

    async function editContractorInfo(data: IEditContractor) {           //изменение инфы подрядчика
        const response = await editContractor(data);

        if (response instanceof AxiosError) {
            console.log(response.message);
<<<<<<< Updated upstream
            setIsEditDialogOpen(false);
            return;
        } else {
=======
            toast({
                variant: "destructive",
                title: "Ошибка при изменении данных подрядчика",
                description: response.message,
            });
            return;
        } else {
            toast({
                title: `Данные подрядчика '${response.name}' изменены`,
            }); 
>>>>>>> Stashed changes
            getAllContractors().then(() => setIsEditDialogOpen(false));
        }
    }

    async function addContractor(data: IAddContractor) {
        const response = await createContractor(data);
    
        if (response instanceof AxiosError) {
            console.log(response.message);
<<<<<<< Updated upstream
            setIsAddDialogOpen(false);
            return;
        } else {
=======
            toast({
                variant: "destructive",
                title: "Ошибка при создании подрядчика",
                description: response.message,
            });
            return;
        } else {
            toast({
                title: `Подрядчик '${response.name}' создан`,
            }); 
>>>>>>> Stashed changes
            getAllContractors().then(() => setIsAddDialogOpen(false));
        }
    }

    async function removeContractor(id: number) {    //удаление подрядчика
        const response = await deleteContractor(id);
    
        if (response instanceof AxiosError) {
          console.log(response.message);
<<<<<<< Updated upstream
          return;
        } else {
=======
          toast({
            variant: "destructive",
            title: "Ошибка при удалении подрядчика",
            description: response.message,
            });
          return;
        } else {
            toast({
                title: `Подрядчик '${response.name}' удалён`,
            }); 
>>>>>>> Stashed changes
            getAllContractors();
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
        // {
        //     accessorKey: "id",
        //     header: ({ column }) => (
        //         <DataTableColumnHeader column={column} title="Подрядчик" />
        //     ),
        //     cell: ({ row }) => (
        //         <div className="w-[50px]">{"Подрядчик-" + row.getValue("id")}</div>
        //     ),
        //     enableSorting: false,
        //     enableHiding: false,
        // },
        {
<<<<<<< Updated upstream
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
=======
>>>>>>> Stashed changes
            accessorKey: "name",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Название" />
            ),
            cell: ({ row }) => {
                return (
                    <div className="flex space-x-2">
<<<<<<< Updated upstream
                        <span className="max-w-[100px] truncate font-medium">
=======
                        <span className="max-w-[150px] truncate font-medium">
>>>>>>> Stashed changes
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
                    <span className="max-w-[200px] truncate font-medium">
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
<<<<<<< Updated upstream
            accessorKey: "phoneNumber",
=======
            accessorKey: "phoneNum",
>>>>>>> Stashed changes
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Телефон" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
<<<<<<< Updated upstream
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("phoneNumber") ? row.getValue("contractorPhoneNum") : "Не указано"}
=======
                    <span className="max-w-[120px] truncate font-medium">
                    {row.getValue("phoneNum") ? row.getValue("phoneNum") : "Не указано"}
>>>>>>> Stashed changes
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
            accessorKey: "paymentNum",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Карта" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
<<<<<<< Updated upstream
                    <span className="max-w-[100px] truncate font-medium">
=======
                    <span className="max-w-[200px] truncate font-medium">
>>>>>>> Stashed changes
                    {row.getValue("paymentNum")}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Карта",
            },
    
        },
        {
            id: "actions",
            cell: ({ row }) => (
                <DataTableRowActions
                    row={row}
                    rowId={row.original.id}
                    isOperations={true}
                    onDelete={() => removeContractor(row.original.id)} 
                    onUpdate={returnUpdateForm}
                />
            ),
        },
    ];

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
                    <Dialog open={isAddDialogOpen} onOpenChange={setIsAddDialogOpen}>
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
                            <ContractorForm handleFormSubmit={addContractor} isEdit={false} />
                        </DialogContent>
                    </Dialog>

<<<<<<< Updated upstream
                    <DataTable title="name" data={contractors} columns={columns} additionalFilters={additionalFilters} /> 
=======
                    <DataTable title="name" data={contractors} columns={columns} additionalFilters={additionalFilters} isToolbar={true} isTablePagination={true} /> 
>>>>>>> Stashed changes
                </div>
            </div>
        </ProtectedLayout>
    );
}   