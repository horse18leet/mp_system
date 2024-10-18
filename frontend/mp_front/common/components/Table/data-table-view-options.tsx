"use client";

import { DropdownMenuTrigger } from "@radix-ui/react-dropdown-menu";

import { Filter } from "lucide-react";

import { Button } from "@/common/components/ui/button";

import {
  DropdownMenu,
  DropdownMenuCheckboxItem,
  DropdownMenuContent,
  DropdownMenuLabel,
  DropdownMenuSeparator,
} from "@/common/components/ui/dropdown-menu";

import { DataTableViewOptionsProps } from "./types/data-table-types";
import Header from '../Header/Header';

export function DataTableViewOptions<TData>({
  table,
  additionalFilters,
}: DataTableViewOptionsProps<TData>) {
  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <Button
          variant="outline"
          size="sm"
          className="ml-auto hidden h-8 lg:flex"
        >
          <Filter className="mr-2 h-4 w-4" />
          Фильтр
        </Button>
      </DropdownMenuTrigger>
      <DropdownMenuContent align="end" className="w-auto p-3">
        <DropdownMenuLabel className="py-2 text-center px-2">Отобразить колонки</DropdownMenuLabel>
        <DropdownMenuSeparator />
        {table
          .getAllColumns()
          .filter(
            (column) =>
              typeof column.accessorFn !== "undefined" && column.getCanHide()
          )
          .map((column) => {
            return (
              <DropdownMenuCheckboxItem
                key={column.id}
                className="capitalize py-2"
                checked={column.getIsVisible()}
                onCheckedChange={(value) => column.toggleVisibility(!!value)}
              >
                {column.columnDef.meta?.filterDisplayName}
              </DropdownMenuCheckboxItem>
            );
          })
        }

        {
          additionalFilters ? 
            <>
              <DropdownMenuLabel className="py-2 text-center px-2 mt-[10px]">Отобразить товары</DropdownMenuLabel>
              <DropdownMenuSeparator />
                {additionalFilters.map((filter) => (
                  <DropdownMenuCheckboxItem
                    key={filter.label}
                    className="capitalize py-2"
                    // checked={filter.getIsVisible()}
                    // onCheckedChange={(value) => filter.toggleVisibility(!!value)}
                  >
                    {filter.label}
                  </DropdownMenuCheckboxItem>
                  ))
                }
            </>
            :
            <></>
        }
      </DropdownMenuContent>
    </DropdownMenu>
  );
}
