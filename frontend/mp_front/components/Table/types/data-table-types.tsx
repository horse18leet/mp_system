import { Column, ColumnDef, RowData } from "@tanstack/react-table";
import { Table } from "@tanstack/react-table";
import { Row } from "@tanstack/react-table";
import { Dispatch, SetStateAction } from "react";
import { ZodSchema } from "zod";

interface IconProps {
  className?: string;
}

/*
export interface RowAction {              //интерфейс для действий, которые совершаются над строками таблицы
  title: string;
  onClick?:  () => void;
}*/

export interface FacetedFilterOption {
  label: string;
  value: string;
  icon?: React.ComponentType<IconProps>;
}

declare module '@tanstack/table-core' {
  interface ColumnMeta<TData extends RowData, TValue> {
    filterDisplayName: string
  }
}

export interface DataTableViewOptionsProps<TData> {
  table: Table<TData>;
  additionalFilters: FacetedFilterOption[];               //пока так, староста, не злись
}

export interface DataTableColumnHeaderProps<TData, TValue>
  extends React.HTMLAttributes<HTMLDivElement> {
  column: Column<TData, TValue>;
  title: string;
}

export interface DataTablePaginationProps<TData> {
  table: Table<TData>;
}

export interface DataTableRowActionsProps<TData> {
  // rowActions: RowAction[];                            //массив действий
  row: Row<TData>;
  onUpdate?: () => Promise<void>;
  onDelete?: () => Promise<void>;
  onOperations?: () => void;
}

export interface DataTableFacetedFilterProps<TData, TValue> {
  column?: Column<TData, TValue>;
  title?: string;
  options: FacetedFilterOption[];
}

export interface DataTableToolbarProps<TData> {
  table: Table<TData>;
  additionalFilters: FacetedFilterOption[];               //пока так, староста, не злись
  title: string;

}

export interface DataTableProps<TData, TValue> {
  columns: ColumnDef<TData, TValue>[];
  additionalFilters: FacetedFilterOption[];               //пока так, староста, не злись
  data: TData[];
  title: string;
}
