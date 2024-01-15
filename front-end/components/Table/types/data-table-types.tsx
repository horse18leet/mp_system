import { Column, ColumnDef, RowData } from "@tanstack/react-table";
import { Table } from "@tanstack/react-table";
import { Row } from "@tanstack/react-table";
import { ZodSchema } from "zod";

interface IconProps {
  className?: string;
}

interface FacetedFilterOption {
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
  row: Row<TData>;
  onUpdate?: () => Promise<void>;
  onDelete?: () => Promise<void>;
}

export interface DataTableFacetedFilterProps<TData, TValue> {
  column?: Column<TData, TValue>;
  title?: string;
  options: FacetedFilterOption[];
}

export interface DataTableToolbarProps<TData> {
  table: Table<TData>;
}

export interface DataTableProps<TData, TValue> {
  columns: ColumnDef<TData, TValue>[];
  data: TData[];
}
