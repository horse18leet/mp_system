"use client";

import { MoreHorizontal } from "lucide-react";

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
import { DataTableRowActionsProps } from "./types/data-table-types";
import { Dialog, DialogTrigger, DialogContent } from "../ui/dialog";
import { useState } from "react";

export function DataTableRowActions<TData>({
  row,
  rowId,
  onDelete,
  onUpdate,
  onOperations,
}: DataTableRowActionsProps<TData>) {

  function handleOperationsClick() {
    onOperations;
    // console.log(rowId);
  }

  return (
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
        {/* {
          rowActions.map((rowAction, index) => (
            <>
              <DropdownMenuItem className="cursor-pointer">{rowAction.title}</DropdownMenuItem>
              {index < rowActions.length - 1 ? 
                <DropdownMenuSeparator /> 
                :
                <></>
              }
            </>
          ))
        } */}
        
        <DropdownMenuItem className="cursor-pointer" onClick={onOperations}>Операции</DropdownMenuItem>
        <DropdownMenuSeparator />
        <DropdownMenuItem className="cursor-pointer">Изменить</DropdownMenuItem>
        <DropdownMenuSeparator />
        <DropdownMenuItem className="cursor-pointer" onClick={onDelete}>Удалить</DropdownMenuItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
}
