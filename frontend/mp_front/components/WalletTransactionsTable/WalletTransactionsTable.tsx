import { useState, useEffect } from "react";

import IWalletTransactionResponse from "@/utils/models/wallet-transaction/wallet-transaction-response";
import { createWalletTransaction, deleteWalletTransaction, getItemWalletTransactions } from "@/utils/api/services/wallet-transactions.service";
import { IAddWalletTransaction, addWalletTransactionScheme } from "@/utils/schemas/wallet-transaction/add-wallet-transaction.scheme";

import { getContractors } from "@/utils/api/services/contractor.service";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

import { getItem } from "@/utils/api/services/item.service";

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



function WalletTransactionsTable({itemId}: any) {
    const [walletTransactions, setwalletTransactions] = useState<any>([]);
    const [contractorsArr, setContractorsArr] = useState<IContractorResponse[]>([]);

    const [isDialogFormOpen, setIsDialogFormOpen] = useState(false);
    const [isPopoverContractorOpen, setIsPopoverContractorOpen] = useState(false);  
    const [isPopoverTypeOpen, setIsPopoverTypeOpen] = useState(false);  

    const typesArr = ["Приход", "Расход"];

    useEffect(() => {
      getAllWalletTransactions(itemId);
      getAllContractors();
    }, []);

    // async function getCurrentItem() {
    //   const item = await getItem();
    //   setContractorsArr(contractors);
    // }

    async function getAllContractors() {
      const contractors = await getContractors();
      setContractorsArr(contractors);
    }

    async function getAllWalletTransactions(id: number) {
      const transactions = await getItemWalletTransactions(id);
    
      setwalletTransactions(transactions);
    }

    async function removeWalletTransaction(id: number) {    //удаление подрядчика
      const response = await deleteWalletTransaction(id);
  
      if (response instanceof AxiosError) {
        console.log(response.message);
        return;
      } else {
        getAllWalletTransactions(itemId);
      }
  }

    function getSelectedContractor() {
      const contractorName = addWalletTransactionForm.getValues("contractorDto");
      const selectedContractor = contractorsArr.find(contractor => contractor.name === contractorName); 
      return selectedContractor;
    }

    async function addWalletTransaction(data: IAddWalletTransaction) {
      const currentContractor = getSelectedContractor();
      const currentItem = await getItem(itemId);
      data["itemDto"] = currentItem;
      data["contractorDto"] = currentContractor;

      console.log(data);

      const response = await createWalletTransaction(itemId, data);
  
      if (response instanceof AxiosError) {
        console.log(response.message);
        setIsDialogFormOpen(false);
        return;
      } else {
        getAllWalletTransactions(itemId).then(() => setIsDialogFormOpen(false));
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
      accessorKey: "contractorDto",
      header: ({ column }) => (
        <DataTableColumnHeader column={column} title="Подрядчик" />
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
        filterDisplayName: "contractorDto",
      },
    },
    {
      id: "actions",
      cell: ({ row }) => (
        <DataTableRowActions
          row={row}
          rowId={row.original.id}
          onDelete={() => removeWalletTransaction(row.original.id)}
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
                  onSubmit={addWalletTransactionForm.handleSubmit(addWalletTransaction)}
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
                  <FormField
                    control={addWalletTransactionForm.control}
                    name="contractorDto"
                    defaultValue=""
                    render={({ field }) => (
                      <FormItem className="flex flex-col">
                        <FormLabel>Подрядчик</FormLabel>
                        <Popover open={isPopoverContractorOpen} onOpenChange={setIsPopoverContractorOpen}>
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
                                      setIsPopoverContractorOpen(false);
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