import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from "@/components/ui/dialog";

import { PurchaseProps } from "./types/purchase-types";
import { useEffect, useState } from "react";

export default function Purchase({
    isOpen, 
    setIsOpen,
    itemsList,
}: PurchaseProps) {
    
    const [currentItem, setCurrentItem] = useState(itemsList[0]);
    useEffect(() => {
        console.log("массив: ", itemsList);
    });


    return (
        <Dialog open={isOpen} onOpenChange={setIsOpen}>
            <DialogContent>
                <DialogHeader>
                    <DialogTitle>{currentItem ? currentItem.title : "хуй"}</DialogTitle>
                </DialogHeader>
            </DialogContent>
        </Dialog>
    );
} 