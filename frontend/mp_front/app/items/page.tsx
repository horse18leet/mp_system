"use client";
import ProtectedLayout from "@/common/components/ProtectedLayout/ProtectedLayout";
import { ReactNode, useEffect, useState } from "react";

import { ColumnDef } from "@tanstack/react-table";

import { Checkbox } from "@/common/components/ui/checkbox";

import IItemResponse from "@/common/utils/models/item/item-response";

import { DataTableColumnHeader } from "../../common/components/Table/data-table-column-header";
import { DataTableRowActions } from "../../common/components/Table/data-table-row-actions";
import { DataTable } from "@/common/components/Table/data-table";
import {
  createItem,
  deleteItem,
  editItem,
  getItems,
} from "@/common/utils/api/services/item.service";
import { AxiosError } from "axios";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/common/components/ui/dialog";

import {
  Tooltip,
  TooltipContent,
  TooltipProvider,
  TooltipTrigger,
} from "@/common/components/ui/tooltip"

import { Button } from "@/common/components/ui/button";

import { IAddItem } from "@/common/utils/schemas/item/add-item.scheme";
import { FacetedFilterOption } from "@/common/components/Table/types/data-table-types";

import ItemForm from "@/common/components/CustomForms/ItemForm/ItemForm";
import Purchase from "@/common/components/Purchase/Purchase";

import { useToast } from "@/common/components/ui/use-toast";

export default function Items() {
  const [items, setItems] = useState<IItemResponse[]>([]); //староста, тут ошибка, я пока по-другому сделаю
  const [isAddDialogOpen, setIsAddDialogOpen] = useState(false);
  const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);
  const [isCheckBox, setIsCheckBox] = useState(false);
  const [isPurchaseDialogOpen, setIsPurchaseDialogOpen] = useState(false);
  const [purchaseItems, setPurchaseItems] = useState<IItemResponse[]>([]);
  const { toast } = useToast();

  useEffect(() => {
    getAllItems();
  }, []);

  function addItemToPurchase(data: any, isAdd: boolean) {                    //метод добавления товаров в окно закупа
    if (isAdd) {
      const tempArr = Object.assign([], purchaseItems);
      tempArr.push(data);

      setPurchaseItems(tempArr);
      setIsCheckBox(true);
    } else {
      const tempArr = purchaseItems.filter(item => item.id !== data.id);
      setPurchaseItems(tempArr);

      if (purchaseItems.length == 1) {
        setIsCheckBox(false);
      }
    }
  }

  function addAllItemsToPurchase(data: any, isChecked: boolean) {                                //обработчик нажатия на чекбокс выбора всех строк
    if (isChecked) {
      const rows = data["rows"];
      const itemsArr = rows.map((rowItem: any) => rowItem["original"]);

      setPurchaseItems(itemsArr);
      setIsCheckBox(true);
    } else {
      setPurchaseItems([]);
      setIsCheckBox(false);
    }
  }

  function handlePurchaseButtonClick() {
    setIsPurchaseDialogOpen(!isPurchaseDialogOpen);
  }

  function returnUpdateForm(data: any): ReactNode {                          //возвращаем разметку, которую вставим в Dialog
    const item = data.original;
    // console.log(item);
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
      toast({
        variant: "destructive",
        title: "Ошибка при удалении товара",
        description: response.message,
      });
      return;
    } else {
      toast({
        title: `Товар '${response.title}' удалён`,
      });

      getAllItems(); // В противном случае обновляем UI.
    }
  }

  async function addItem(data: IAddItem) {
    const response = await createItem(data);

    if (response instanceof AxiosError) {
      console.log(response.message);
      toast({
        variant: "destructive",
        title: "Ошибка при создании товара",
        description: response.message,
      });      
      return;
    } else {
      toast({
        title: `Товар '${response.title}' создан`,
      });    
      getAllItems().then(() => setIsAddDialogOpen(false));
    }
  }

  async function editItemInfo(data: IAddItem) {           //изменение инфы о товаре
    console.log(data);
    const response = await editItem(data);

    if (response instanceof AxiosError) {
      console.log(response.message);
      toast({
        variant: "destructive",
        title: "Ошибка при изменении информации о товаре",
        description: response.message,
      });   
      return;
    } else {
      toast({
        title: `Товар '${response.title}' изменён`,
      });   
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
          onCheckedChange={
            (value) => {
              table.toggleAllPageRowsSelected(!!value);
              addAllItemsToPurchase(table.getPreSelectedRowModel(), !!value);            
            }
          }
          aria-label="Select all"
          className="translate-y-[2px]"
        />
      ),
      cell: ({ row }) => (
        <Checkbox
          checked={row.getIsSelected()}
          onCheckedChange={
            (value) => {
              row.toggleSelected(!!value);
              // setIsCheckBox(!!value);
              addItemToPurchase(row.original, !!value); 
            }
          }
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

  return (
    <ProtectedLayout>
      {
        isPurchaseDialogOpen ?
        <Purchase                       //закупы
          isOpen={isPurchaseDialogOpen}   
          setIsOpen={setIsPurchaseDialogOpen}  
          itemsList={purchaseItems}
        /> : <></>
      }
      <div className="container pt-8 h-full mb-[50px]">
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
              <div className="flex"> 
                <TooltipProvider>
                  <Tooltip>
                    <TooltipTrigger asChild>
                      <div className="w-min mr-[20px]">
                        <Button 
                          variant="default" 
                          className="px-4 py-2 h-9" 
                          disabled={isCheckBox ? false : true}
                          onClick={handlePurchaseButtonClick}
                        >
                          Добавить в закуп
                        </Button>
                      </div>
                    </TooltipTrigger>
                    {
                      isCheckBox ? 
                      <></>
                      :
                      <TooltipContent side="bottom">
                        <p>Сначала выберите товар</p>
                      </TooltipContent>
                    }
                  </Tooltip>
                </TooltipProvider>
                <DialogTrigger asChild>
                  <Button variant="default" className="px-4 py-2 h-9" >
                    Добавить товар
                  </Button>
                </DialogTrigger>
              </div>
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
          <DataTable title="title" data={items} columns={columns} additionalFilters={additionalFilters} isToolbar={true} isTablePagination={true} />
        </div>
      </div>
    </ProtectedLayout>
  );
}
