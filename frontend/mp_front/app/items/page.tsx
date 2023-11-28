"use client";
import Link from "next/link";
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
// import { getItems, deleteItem } from "@/utils/utils";
import { useEffect, useState } from "react";

import { ColumnDef } from "@tanstack/react-table";

import { Checkbox } from "@/components/ui/checkbox";

import IItemResponse from "@/utils/models/item";

import { DataTableColumnHeader } from "../../components/Table/data-table-column-header";
import { DataTableRowActions } from "../../components/Table/data-table-row-actions";
import { DataTable } from "@/components/Table/data-table";
import { deleteItem, getItems } from "@/utils/api/services/item.service";
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

export default function Items() {
  const [items, setItems] = useState<IItemResponse[]>([]);

  useEffect(() => {
    getAllItems();
  }, []);

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

  //   async function handleDeleteProduct(
  //     event: React.MouseEvent<HTMLElement>,
  //     itemId: string
  //   ) {
  //     //удаление товара
  //     const result = await deleteItem(itemId);
  //     result.error ? alert(result.error) : getAllItems(); //удаляем товар из таблицы, если запрос прошёл
  //   }

  // Настройка колонок таблицы
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
          onDelete={() => removeItem(row.original.id)}
        />
      ),
    },
  ];

  return (
    <ProtectedLayout>
      <div className="container pt-8 h-full">
        <div className="flex-col space-y-8 md:flex hidden">
          <Dialog>
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
              <div className="grid gap-4 py-4">
                <div className="grid grid-cols-4 items-center gap-4">
                  
                </div>
              </div>
            </DialogContent>
          </Dialog>
          <DataTable data={items} columns={columns} />
        </div>
      </div>
      {/* <section className={styles.main}>
        <h1 className="mr-auto ml-[0px] mb-[20px] text-2xl">Мои товары</h1>
        {items.length > 0 ? (
          <>
            <Link
              href="/items/new"
              className="mr-auto ml-[0px] mb-[20px] products__link link"
            >
              Добавить товар
            </Link>
            
          </>
        ) : (
          <>
            <h2>У вас нет товаров</h2>
            <Link href="/items/new" className="products__link link">
              Добавить товар
            </Link>
          </>
        )}
      </section> */}
    </ProtectedLayout>
  );
}
