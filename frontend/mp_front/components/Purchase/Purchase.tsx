import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";

import { joiResolver } from "@hookform/resolvers/joi";

import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from "@/components/ui/dialog";

import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form";

import { PurchaseProps } from "./types/purchase-types";
import { IAddPurchase } from "@/utils/schemas/purchase/add-purchase.scheme";
import { Button } from "../ui/button";

export default function Purchase({
    isOpen, 
    setIsOpen,
    itemsList,
}: PurchaseProps) {

    const [currentIndex, setCurrentIndex] = useState(1);
    const [currentItem, setCurrentItem] = useState(itemsList[0]);
    const [errMessage, setErrMessage] = useState("");
    const [buttonText, setButtonText] = useState("К следующему товару");

    const purchaseForm = useForm<IAddPurchase>({
        
    });


    function handleFormSubmit() {           //временно
        setCurrentIndex(currentIndex + 1);
        if (currentIndex < itemsList.length) {
            setCurrentItem(itemsList[currentIndex]);
        }
        else {
            setButtonText("Выйти");
            setIsOpen(false);
        }
    }


    return (
        <Dialog open={isOpen} onOpenChange={setIsOpen}>
            <DialogContent>
                <DialogHeader>
                    <DialogTitle>{currentItem ? currentItem.title : errMessage}</DialogTitle>
                    {/* <DialogDescription>{errMessage}</DialogDescription> */}
                    <Button onClick={handleFormSubmit}>{buttonText}</Button>
                </DialogHeader>
            </DialogContent>
        </Dialog>
    );
} 