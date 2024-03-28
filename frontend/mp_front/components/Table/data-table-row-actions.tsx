"use client";

import { useState } from "react";

import { MoreHorizontal } from "lucide-react";

import { DataTableRowActionsProps } from "./types/data-table-types";

import { Button } from "@/components/ui/button";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuRadioGroup,
  DropdownMenuRadioItem,
  DropdownMenuSeparator,
  DropdownMenuShortcut,
  DropdownMenuSub,
  DropdownMenuSubContent,
  DropdownMenuSubTrigger,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu";

import {
  Dialog, 
  DialogContent, 
  DialogHeader, 
  DialogTitle 
} from "../ui/dialog";

import WalletTransactionsTable from "../WalletTransactionsTable/WalletTransactionsTable";

export function DataTableRowActions<TData>({
  row,
  rowId,
  isOperations,
  onDelete,
  onUpdate,
  onOperations,
}: DataTableRowActionsProps<TData>) {

  const [isOperationsDialogOpen, setIsOperationsDialogOpen] = useState(false);
  
  function openDialog() {
    setIsOperationsDialogOpen(!isOperationsDialogOpen);
  }

  return (
    <>
      <DropdownMenu>
        <DropdownMenuTrigger asChild>
          <Button
            variant="ghost"
            className="flex h-8 w-8 p-0 data-[state=open]:bg-muted"
          >
            <MoreHorizontal className="h-4 w-4" />
            <span className="sr-only">Открыть меню</span>
          </Button>
        </DropdownMenuTrigger>
        <DropdownMenuContent align="end" className="w-[160px]">
          {
            isOperations ? 
            <>
              <DropdownMenuItem className="cursor-pointer" onClick={openDialog}>Операции</DropdownMenuItem>
              <DropdownMenuSeparator />
            </>
            :
            <></>
          }
          
          <DropdownMenuItem className="cursor-pointer">Изменить</DropdownMenuItem>
          <DropdownMenuSeparator />
          <DropdownMenuItem className="cursor-pointer" onClick={onDelete}>Удалить</DropdownMenuItem>
        </DropdownMenuContent>
      </DropdownMenu>
      
      {/* Таблица с операциями */}
      <Dialog open={isOperationsDialogOpen} onOpenChange={setIsOperationsDialogOpen}>   
        <DialogContent className="min-w-[1000px]">
          <DialogHeader>
              <DialogTitle>Операции</DialogTitle>
          </DialogHeader>
          <WalletTransactionsTable dataId={rowId} />              
        </DialogContent>
      </Dialog>
    </>
  );
}
