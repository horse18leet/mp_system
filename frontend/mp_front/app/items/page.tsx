"use client";
import Link from "next/link";
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
import { ReactNode, useEffect, useState } from "react";

import { ColumnDef } from "@tanstack/react-table";

import { Checkbox } from "@/components/ui/checkbox";

import IItemResponse from "@/utils/models/item/item-response";

import { DataTableColumnHeader } from "../../components/Table/data-table-column-header";
import { DataTableRowActions } from "../../components/Table/data-table-row-actions";
import { DataTable } from "@/components/Table/data-table";
import {
  createItem,
  deleteItem,
  editItem,
  getItems,
} from "@/utils/api/services/item.service";
import { AxiosError } from "axios";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import {
  Select,
  SelectContent,
  SelectGroup,
  SelectItem,
  SelectLabel,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useForm } from "react-hook-form";
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
import { IAddItem, addItemScheme } from "@/utils/schemas/item/add-item.scheme";
import { FacetedFilterOption } from "@/components/Table/types/data-table-types";
import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from "@/components/ui/popover";
import { Check, ChevronsUpDown } from "lucide-react";
import { cn } from "@/lib/utils";
import {
  Command,
  CommandEmpty,
  CommandGroup,
  CommandInput,
  CommandItem,
} from "@/components/ui/command";
import { Textarea } from "@/components/ui/textarea";
import { updateToken } from "@/utils/api/auth/auth";
import ItemForm from "@/components/CustomForms/ItemForm/ItemForm";


export default function Items() {
  const [items, setItems] = useState<IItemResponse[]>([]); //староста, тут ошибка, я пока по-другому сделаю
  const [isAddDialogOpen, setIsAddDialogOpen] = useState(false);
  const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);
  const [isPopoverOpen, setIsPopoverOpen] = useState(false);  

  useEffect(() => {
    getAllItems();
  }, []);

  function returnUpdateForm(data: any): ReactNode {                          //возвращаем разметку, которую вставим в Dialog
    const item = data.original;
    console.log(item);
    return (
        <DialogContent>
            <DialogHeader>
                <DialogTitle>Изменить информацию о товаре</DialogTitle>
            </DialogHeader>
            <ItemForm handleFormSubmit={editItemInfo} isEdit={true} item={item}/>
        </DialogContent>
    );
}
  
  async function getAllItems() {
    const items = await getItems();

    setItems(items);
  }

  async function removeItem(id: number) {
    const response = await deleteItem(id);

    if (response instanceof AxiosError) {
      // Если получили ошибку, выходим из функции
      console.log(response.message);
      return;
    } else {
      getAllItems(); // В противном случае обновляем UI.
    }
  }

  async function addItem(data: IAddItem) {
    const response = await createItem(data);

    if (response instanceof AxiosError) {
      console.log(response.message);
      setIsAddDialogOpen(false);
      return;
    } else {
      getAllItems().then(() => setIsAddDialogOpen(false));
    }
  }

  async function editItemInfo(data: IAddItem) {           //изменение инфы о товаре
    console.log(data);
    const response = await editItem(data);

    if (response instanceof AxiosError) {
      console.log(response.message);
      setIsEditDialogOpen(false);
        return;
    } else {
      getAllItems().then(() => setIsEditDialogOpen(false));
    }
}

  // Настройка колонок основной таблицы
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
      accessorKey: "id",
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title="Товар" />
      ),
      cell: ({ row }) => (
        <div className="w-[80px]">{"ТОВАР-" + row.getValue("id")}</div>
      ),
      enableSorting: false,
      enableHiding: false,
    },
    {
      accessorKey: "title",
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title="Название" />
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
      accessorKey: "firstPrice",
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title="Цена без скидки" />
      ),
      cell: ({ row }) => {
        return (
          <div className="flex space-x-2">
            <span className="max-w-[100px] truncate font-medium">
              {row.getValue("firstPrice")}
            </span>
          </div>
        );
      },
      meta: {
        filterDisplayName: "Цена без скидки",
      },
    },
    {
      id: "actions",
      cell: ({ row }) => (
        <DataTableRowActions
          row={row}
          rowId={row.original.id}
          isOperations={true}
          onDelete={() => removeItem(row.original.id)}
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


  const addItemForm = useForm<IAddItem>({
    resolver: joiResolver(addItemScheme),
  });

  // Заглушка пока нет получения категорий
  const categories = [
    { value: "Обувь" },
    { value: "Верхняя одежда" },
    { value: "Брюки" },
    { value: "Электроника" },
  ] as const;

  return (
    <ProtectedLayout>
      <div className="container pt-8 h-full">
        <div className="flex-col space-y-8 md:flex hidden">
          <Dialog open={isAddDialogOpen} onOpenChange={setIsAddDialogOpen}>
            <div className="flex items-center justify-between">
              <div>
                <h2 className="text-2xl font-bold tracking-tight">
                  Список товаров
                </h2>
                <p className="text-muted-foreground">
                  Отслеживайте доступные товары или добавьте новый
                </p>
              </div>
              <DialogTrigger asChild>
                <Button variant="default" className="px-4 py-2 h-9">
                  Добавить товар
                </Button>
              </DialogTrigger>
            </div>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>Добавить товар</DialogTitle>
                <DialogDescription>
                  Заполните все обязательные поля, чтобы добавить новый товар
                </DialogDescription>
              </DialogHeader>
              <ItemForm handleFormSubmit={addItem} isEdit={false}/>
            </DialogContent>
          </Dialog>
          <DataTable title="title" data={items} columns={columns} additionalFilters={additionalFilters} />
        </div>
      </div>
    </ProtectedLayout>
  );
}
