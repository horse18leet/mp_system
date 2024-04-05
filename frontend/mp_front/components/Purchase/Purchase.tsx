import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from "@/components/ui/dialog";

import { PurchaseProps } from "./types/purchase-types";

export default function Purchase({
    isOpen, 
    setIsOpen,
    itemsList,
}: PurchaseProps) {

    return (
        <Dialog open={isOpen} onOpenChange={setIsOpen}>
            <DialogContent>
                wddwdwdwdwdwdwdwdwdwdwd
            </DialogContent>
        </Dialog>
    );
} 