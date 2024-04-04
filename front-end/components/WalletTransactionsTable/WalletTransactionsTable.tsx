import { useState, useEffect } from "react";

import { 
  createContractorWalletTransaction,
  createItemWalletTransaction,
  deleteWalletTransaction,
  getContractorWalletTransactions,
  getItemWalletTransactions,
} from "@/utils/api/services/wallet-transactions.service";
import IWalletTransactionResponse from "@/utils/models/wallet-transaction/wallet-transaction-response";
import { IAddWalletTransaction, addWalletTransactionScheme } from "@/utils/schemas/wallet-transaction/add-wallet-transaction.scheme";

import { getContractor, getContractors } from "@/utils/api/services/contractor.service";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

import { getItem, getItems } from "@/utils/api/services/item.service";
import IItemResponse from "@/utils/models/item/item-response";

import { Checkbox } from "@/components/ui/checkbox";

import { ColumnDef } from "@tanstack/react-table";
import { DataTableColumnHeader } from "../Table/data-table-column-header";
import { DataTableRowActions } from "../Table/data-table-row-actions";
import { DataTable } from "../Table/data-table";

import { useForm } from "react-hook-form";
import { joiResolver } from "@hookform/resolvers/joi";
import { AxiosError } from "axios";

import { 
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "../ui/dialog";

import {
  Form,
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "../ui/form";

import { Button } from "../ui/button";
import { Input } from "../ui/input";
import { Textarea } from "../ui/textarea";

import { 
  Popover,
  PopoverTrigger,
  PopoverContent,
} from "../ui/popover";

import {
  Command,
  CommandEmpty,
  CommandGroup,
  CommandInput,
  CommandItem,
} from "../ui/command";

import { cn } from "@/lib/utils";

import { 
  Check,
  ChevronsUpDown,
} from "lucide-react";

import {usePathname } from "next/navigation";


function WalletTransactionsTable({dataId}: any) {
    const currentPage = usePathname();

    const [walletTransactions, setwalletTransactions] = useState<any>([]);
    const [contractorsArr, setContractorsArr] = useState<IContractorResponse[]>([]);
    const [itemsArr, setItemsArr] = useState<IItemResponse[]>([]);

    const [isDialogFormOpen, setIsDialogFormOpen] = useState(false);
    const [isSecondaryPopoverOpen, setIsSecondaryPopoverOpen] = useState(false);  
    const [isPopoverTypeOpen, setIsPopoverTypeOpen] = useState(false);  

    const dtoRowKey = currentPage === "/items" ? "contractorDto" : "itemDto";       //данные для столбца
    const dtoRowTitle = currentPage === "/items" ? "Подрядчик" : "Товар";
    const submitFunction =  currentPage === "/items" ? addItemWalletTransaction : addContractorWalletTransaction;

    const typesArr = ["Приход", "Расход"];

    useEffect(() => {
      if (currentPage === "/items") {
        getAllItemWalletTransactions(dataId);
        getAllContractors();
      } 
      else if (currentPage === "/contractors") {
        getAllContractorWalletTransactions(dataId);
        getAllItems();
      }
    }, []);

    function getValueByKey(row: any, objName: string) {             //извлекаем название из объекта
      const key = currentPage === "/items" ? "name" : "title";
      const data = row.original;
      try {
        const obj = data[objName];
        return obj[key];

      } catch(e) {
        return "Ошибка";
      }
    }

    async function getAllItems() {    //получение всех товаров
      const items = await getItems();
      setItemsArr(items);
    }

    async function getAllItemWalletTransactions(id: number) {   //получение всех операций товара
      const transactions = await getItemWalletTransactions(id);
      // console.log(transactions);

      setwalletTransactions(transactions);
    }

    async function addItemWalletTransaction(data: IAddWalletTransaction) {
      const currentContractor = getSelectedContractor();
      const currentItem = await getItem(dataId);
      data["itemDto"] = currentItem;
      data["contractorDto"] = currentContractor;

      const response = await createItemWalletTransaction(dataId, data);
  
      if (response instanceof AxiosError) {
        console.log(response.message);
        setIsDialogFormOpen(false);
        return;
      } else {
        getAllItemWalletTransactions(dataId).then(() => setIsDialogFormOpen(false));
      }
    }

    function getSelectedItem() {                                        //получение названия товара для рендера в форме добавления операции
      const itemTitle = addWalletTransactionForm.getValues("itemDto");
      const selectedItem = itemsArr.find(item => item.title === itemTitle); 
      return selectedItem;
    }
 
    async function getAllContractors() {                  //получение всех подрядчиков
      const contractors = await getContractors();
      setContractorsArr(contractors);
    }

    async function getAllContractorWalletTransactions(id: number) {          //получение всех операций подрядчика
      const transactions = await getContractorWalletTransactions(id);
      console.log(transactions);
      setwalletTransactions(transactions);  
    }

    async function addContractorWalletTransaction(data: IAddWalletTransaction) {
      const currentItem = getSelectedItem();
      const currentContractor = await getContractor(dataId);
      data["itemDto"] = currentItem;
      data["contractorDto"] = currentContractor;

      console.log(data);

      const response = await createContractorWalletTransaction(dataId, data);
  
      if (response instanceof AxiosError) {
        console.log(response.message);
        setIsDialogFormOpen(false);
        return;
      } else {
        getAllContractorWalletTransactions(dataId).then(() => setIsDialogFormOpen(false));
      }
    }

    function getSelectedContractor() {                                        //получение имени поставщика для рендера в форме добавления операции
      const contractorName = addWalletTransactionForm.getValues("contractorDto");
      const selectedContractor = contractorsArr.find(contractor => contractor.name === contractorName); 
      return selectedContractor;
    }

    async function removeWalletTransaction(id: number) {    //удаление операции
      const response = await deleteWalletTransaction(id);
  
      if (response instanceof AxiosError) {
        console.log(response.message);
        return;
      } else {
        if (currentPage === "/items") {
          getAllItemWalletTransactions(dataId);
        }
        else if(currentPage === "/contractors") {
          getAllContractorWalletTransactions(dataId);
        }
      }
    }

    const walletTransactionsColumns: ColumnDef<IWalletTransactionResponse>[] = [      //колонки для таблицы операций
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
        <DataTableColumnHeader column={column} title="Операция" />
      ),
      cell: ({ row }) => (
        <div className="w-[80px]">{"Операция-" + row.getValue("id")}</div>
      ),
      enableSorting: false,
      enableHiding: false,
    },
    {
      accessorKey: "amount",
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title="Сумма" />
      ),
      cell: ({ row }) => {
        return (
          <div className="flex space-x-2">
            <span className="max-w-[100px] truncate font-medium">
              {row.getValue("amount")}
            </span>
          </div>
        );
      },
      meta: {
        filterDisplayName: "Сумма",
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
    /*
    {
      accessorKey: "implDate",
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title="implDate" />
      ),
      cell: ({ row }) => {
        return (
          <div className="flex space-x-2">
            <span className="max-w-[100px] truncate font-medium">
              {row.getValue("implDate")}
            </span>
          </div>
        );
      },
      meta: {
        filterDisplayName: "Цена без скидки",
      },
    },
    */
    {
      accessorKey: "createdAt",
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title="Дата создания" />
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
        filterDisplayName: "createdAt",
      },
    },
    {
      accessorKey: dtoRowKey,
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title={dtoRowTitle} />
      ),
      cell: ({ row }) => {
        return (
          <div className="flex space-x-2">
            <span className="max-w-[100px] truncate font-medium">
              {getValueByKey(row, dtoRowKey)}  
            </span>
          </div>
        );
      },
      meta: {
        filterDisplayName: dtoRowKey,
      },
    },
    {
      id: "actions",
      cell: ({ row }) => (
        <DataTableRowActions
          row={row}
          rowId={row.original.id}
          isOperations={false}
          onDelete={() => removeWalletTransaction(row.original.id)}
          onUpdate={() => {return (<></>)}}
        />
      ),
    },
  ];

  const addWalletTransactionForm = useForm<IAddWalletTransaction>({
    resolver: joiResolver(addWalletTransactionScheme),
  });

    return (
      <div className="container pt-8 h-full">
        <div className="flex-col space-y-8 md:flex hidden">
          <Dialog open={isDialogFormOpen} onOpenChange={setIsDialogFormOpen}>
            <div className="flex items-center justify-between">
              <div>
                <h2 className="text-2xl font-bold tracking-tight">
                  Список финансовых операций
                </h2>
              </div>
              <DialogTrigger asChild>
                <Button variant="default" className="px-4 py-2 h-9">
                  Добавить операцию
                </Button>
              </DialogTrigger>
            </div>
            <DialogContent>
              <DialogHeader>
                <DialogTitle>Добавить финансовую операцию</DialogTitle>
                <DialogDescription>
                  Заполните все обязательные поля, чтобы добавить новую операцию
                </DialogDescription>
              </DialogHeader>
              <Form {...addWalletTransactionForm}>
                <form
                  className="flex flex-col gap-4"
                  onSubmit={addWalletTransactionForm.handleSubmit(submitFunction)}
                >
                  <FormField
                    control={addWalletTransactionForm.control}
                    name="amount"
                    defaultValue={0}
                    render={({ field }) => (
                      <FormItem>
                        <FormLabel>Сумма</FormLabel>
                        <FormControl>
                          <Input placeholder="Введите название..." {...field} />
                        </FormControl>
                        <FormDescription />
                        <FormMessage />
                      </FormItem>
                    )}
                  />
                 <FormField
                    control={addWalletTransactionForm.control}
                    name="type"
                    defaultValue=""
                    render={({ field }) => (
                      <FormItem className="flex flex-col">
                        <FormLabel>Тип</FormLabel>
                        <Popover open={isPopoverTypeOpen} onOpenChange={setIsPopoverTypeOpen}>
                          <PopoverTrigger asChild>
                            <FormControl>
                              <Button
                                variant="outline"
                                role="combobox"
                                className={cn(
                                  "justify-between",
                                  !field.value && "text-muted-foreground"
                                )}
                              >
                                {field.value
                                  ? typesArr.find(
                                      (type) =>
                                      type === field.value
                                    )
                                  : "Выберите тип"}
                                <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
                              </Button>
                            </FormControl>
                          </PopoverTrigger>
                          <PopoverContent className="w-[var(--radix-popover-trigger-width)] max-h-[var(--radix-popover-content-available-height)] p-0">
                            <Command>
                              <CommandInput
                                className="border-none focus-visible:ring-ring focus-visible:ring-offset-2"
                                placeholder="Поиск типа..."
                              />
                              <CommandEmpty>Тип не найден.</CommandEmpty>
                              <CommandGroup>
                                {typesArr.map((type) => (
                                  <CommandItem
                                    value={type}
                                    key={type}
                                    onSelect={() => {
                                      addWalletTransactionForm.setValue(
                                        "type",
                                        type
                                      );
                                      setIsPopoverTypeOpen(false);
                                    }}
                                  >
                                    <Check
                                      className={cn(
                                        "mr-2 h-4 w-4",
                                        type === field.value
                                          ? "opacity-100"
                                          : "opacity-0"
                                      )}
                                    />
                                    {type}
                                  </CommandItem>
                                ))}
                              </CommandGroup>
                            </Command>
                          </PopoverContent>
                        </Popover>
                      </FormItem>
                    )}
                  />
                  {
                    currentPage === "/items" ?
                    <FormField
                    control={addWalletTransactionForm.control}
                    name="contractorDto"
                    defaultValue=""
                    render={({ field }) => (
                      <FormItem className="flex flex-col">
                        <FormLabel>Подрядчик</FormLabel>
                        <Popover open={isSecondaryPopoverOpen} onOpenChange={setIsSecondaryPopoverOpen}>
                          <PopoverTrigger asChild>
                            <FormControl>
                              <Button
                                variant="outline"
                                role="combobox"
                                className={cn(
                                  "justify-between",
                                  !field.value && "text-muted-foreground"
                                )}
                              >
                                {field.value
                                  ? contractorsArr.find(
                                      (contractor) =>
                                      contractor.name === field.value
                                    )?.name
                                  : "Выберите подрядчика"}
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
                                      addWalletTransactionForm.setValue(
                                        "contractorDto",
                                        contractor.name
                                      );
                                      setIsSecondaryPopoverOpen(false);
                                    }}
                                  >
                                    <Check
                                      className={cn(
                                        "mr-2 h-4 w-4",
                                        contractor.name === field.value
                                          ? "opacity-100"
                                          : "opacity-0"
                                      )}
                                    />
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
                  :
                  <FormField
                    control={addWalletTransactionForm.control}
                    name="itemDto"
                    defaultValue=""
                    render={({ field }) => (
                      <FormItem className="flex flex-col">
                        <FormLabel>Товар</FormLabel>
                        <Popover open={isSecondaryPopoverOpen} onOpenChange={setIsSecondaryPopoverOpen}>
                          <PopoverTrigger asChild>
                            <FormControl>
                              <Button
                                variant="outline"
                                role="combobox"
                                className={cn(
                                  "justify-between",
                                  !field.value && "text-muted-foreground"
                                )}
                              >
                                {field.value
                                  ? itemsArr.find(
                                      (item) =>
                                      item.title === field.value
                                    )?.title
                                  : "Выберите товар"}
                                <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
                              </Button>
                            </FormControl>
                          </PopoverTrigger>
                          <PopoverContent className="w-[var(--radix-popover-trigger-width)] max-h-[var(--radix-popover-content-available-height)] p-0">
                            <Command>
                              <CommandInput
                                className="border-none focus-visible:ring-ring focus-visible:ring-offset-2"
                                placeholder="Поиск товара..."
                              />
                              <CommandEmpty>Товар не найден.</CommandEmpty>
                              <CommandGroup>
                                {itemsArr.map((item) => (
                                  <CommandItem
                                    value={item.title}
                                    key={item.title}
                                    onSelect={() => {
                                      addWalletTransactionForm.setValue(
                                        "itemDto",
                                        item.title
                                      );
                                      setIsSecondaryPopoverOpen(false);
                                    }}
                                  >
                                    <Check
                                      className={cn(
                                        "mr-2 h-4 w-4",
                                        item.title === field.value
                                          ? "opacity-100"
                                          : "opacity-0"
                                      )}
                                    />
                                    {item.title}
                                  </CommandItem>
                                ))}
                              </CommandGroup>
                            </Command>
                          </PopoverContent>
                        </Popover>
                      </FormItem>
                    )}
                  />
                  }
                  
                  <FormField
                    control={addWalletTransactionForm.control}
                    name="description"
                    defaultValue=""
                    render={({ field }) => (
                      <FormItem>
                        <FormLabel>Описание</FormLabel>
                        <FormControl>
                          <Textarea
                            placeholder="Придумайте описание финансовой операции..."
                            {...field}
                          />
                        </FormControl>
                      </FormItem>
                    )}
                  />
                  <Button type="submit">Добавить</Button>
                </form>
              </Form>
            </DialogContent>
          </Dialog>
          <DataTable title="amount" data={walletTransactions} columns={walletTransactionsColumns} />   
        </div>
      </div>
    );
}

export default WalletTransactionsTable;