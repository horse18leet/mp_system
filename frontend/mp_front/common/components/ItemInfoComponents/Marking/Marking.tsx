import { Button } from "../../ui/button";
import { 
    Card, 
    CardContent, 
    CardHeader, 
    CardTitle 
} from "../../ui/card";

import { DataTable } from "../../Table/data-table";
import { DataTableRowActions } from "../../Table/data-table-row-actions";
import { DataTableColumnHeader } from "../../Table/data-table-column-header";
import { ColumnDef } from "@tanstack/react-table";
import { Checkbox } from "../../ui/checkbox";


interface MarkingProps {

}

export default function Marking({  }: MarkingProps) {

    const testData = [
        {
            id: 1,
            name: "test",
            markicgCode: 228,
            updateDate: "12.10.2024",
            status: "createddwwddwwddwdwwd"
        },
        {
            id: 2,
            name: "test2",
            markicgCode: 228,
            updateDate: "12.10.2024",
            status: "created"
        },
        {
            id: 3,
            name: "test3",
            markicgCode: 228,
            updateDate: "12.10.2024",
            status: "created"
        },
    ];
    
    const columns: ColumnDef<any>[] = [
        /* {
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
        }, */
        {
            accessorKey: "id",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="ID товара" />
            ),
            cell: ({ row }) => (
                <div className="w-[50px]">{row.getValue("id")}</div>
            ),
            enableSorting: false,
            enableHiding: false,
        },
        {
            accessorKey: "name",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Наименование" />
            ),
            cell: ({ row }) => {
                return (
                    <div className="flex space-x-2">
                        {row.getValue("name")}
                    </div>
                );
            },
            meta: {
                filterDisplayName: "Наименование",
            },
        },
        {
            accessorKey: "markicgCode",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Код маркировки" />
            ),
            cell: ({ row }) => {
                return (
                <div className="flex space-x-2">
                    {row.getValue("markicgCode")}
                </div>
                );
            },
            meta: {
                filterDisplayName: "Код маркировки",
            },
        },
        {
            accessorKey: "updateDate",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Дата обновления" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2" >
                    {row.getValue("updateDate")}
                </div>
            );
            },
            meta: {
                filterDisplayName: "Дата обновления",
            },
        },
        {
            accessorKey: "status",
            header: ({ column }) => (
                <DataTableColumnHeader column={column} title="Статус" />
            ),
            cell: ({ row }) => {
            return (
                <div className="flex space-x-2">
                    <span className="max-w-[100px] truncate font-medium">
                    {row.getValue("status")}
                    </span>
                </div>
            );
            },
            meta: {
                filterDisplayName: "Статус",
            },
    
        },
        {
            id: "actions",
            cell: ({ row }) => (
                <DataTableRowActions
                    row={row}
                    rowId={row.original.id}
                    isOperations={false}
                   /*  onDelete={} 
                    onUpdate={} */
                />
            ),
        },
    ];
    
    return (
        <Card>
            <CardHeader className="flex flex-row justify-between items-center">
                <CardTitle>Маркировка</CardTitle>
                <Button variant="default"className="w-[300px]">Сгенерировать маркировку</Button>
            </CardHeader>
            <CardContent>
                <DataTable title="name" columns={columns}  data={testData} isToolbar={false} isTablePagination={false} />
            </CardContent>  
        </Card>
    );
}