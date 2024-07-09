"use client";

import { useEffect, useState } from "react";

import { MoreHorizontal, Trash2, Pencil, Wallet } from "lucide-react";

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
import ContractorForm from "../CustomForms/ContractorForm/ContractorForm";

export function DataTableRowActions<TData>({
  row,
  rowId,
  isOperations,
  onDelete,
  onUpdate,
  onOperations,
}: DataTableRowActionsProps<TData>) {

  const [isOperationsDialogOpen, setIsOperationsDialogOpen] = useState(false);
  const [isEditDialogOpen, setIsEditDialogOpen] = useState(false);

  function openOperationsDialog() {
    setIsOperationsDialogOpen(!isOperationsDialogOpen);
  }

  function openEditDialog() {
    setIsEditDialogOpen(!isEditDialogOpen);
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
              <DropdownMenuItem className="cursor-pointer" onClick={openOperationsDialog}>
                <Wallet size={16} className="mr-[5px]" />
                Операции
              </DropdownMenuItem>
              <DropdownMenuSeparator />
            </>
            :
            <></>
          }
          
          <DropdownMenuItem className="cursor-pointer" onClick={openEditDialog}>
            <Pencil size={16} className="mr-[5px]"/>
            Изменить
          </DropdownMenuItem>
          <DropdownMenuSeparator />
          <DropdownMenuItem className="cursor-pointer" onClick={onDelete}>
            <Trash2 size={16} className="mr-[5px]" /> 
            Удалить
          </DropdownMenuItem>
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

      {/* Таблица с изменением инфы */}
      {
        isEditDialogOpen === true ?
        <Dialog open={isEditDialogOpen} onOpenChange={setIsEditDialogOpen}>
<<<<<<< Updated upstream
          {onUpdate(row)}
=======
          {onUpdate ? onUpdate(row): ""}
>>>>>>> Stashed changes
        </Dialog>
        :
        <></>
      }
      
    </>
  );
}
