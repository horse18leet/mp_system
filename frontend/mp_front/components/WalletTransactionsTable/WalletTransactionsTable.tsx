import { useState, useEffect } from "react";

import IWalletTransactionResponse from "@/utils/models/wallet-transaction/wallet-transaction-response";
import { getItemWalletTransactions } from "@/utils/api/services/item.service";

import { Checkbox } from "@/components/ui/checkbox";

import { ColumnDef } from "@tanstack/react-table";
import { DataTableColumnHeader } from "../Table/data-table-column-header";
import { DataTableRowActions } from "../Table/data-table-row-actions";
import { DataTable } from "../Table/data-table";


function WalletTransactionsTable({itemId}: any) {
    const [walletTransactions, setwalletTransactions] = useState<any>([]);

    useEffect(() => {
        getWalletTransactions(itemId);
    }, []);

    async function getWalletTransactions(itemId: any) {
        const transactions = await getItemWalletTransactions(itemId);
    
        setwalletTransactions(transactions);
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
              {row.getValue("description")}
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
              {row.getValue("description")}
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
        //   onDelete={() => removeItem(row.original.id)}
        />
      ),
    },
  ];

    return (
        <DataTable title="title" data={walletTransactions} columns={walletTransactionsColumns} />   
    );
}

export default WalletTransactionsTable;