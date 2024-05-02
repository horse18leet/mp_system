import { useState, useEffect } from "react";
import { useForm } from "react-hook-form";

import { joiResolver } from "@hookform/resolvers/joi";

import { Button } from "../ui/button";

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

import {
    Command,
    CommandEmpty,
    CommandGroup,
    CommandInput,
    CommandItem,
} from "@/components/ui/command";

import {
    Popover,
    PopoverContent,
    PopoverTrigger,
} from "@/components/ui/popover";

import { 
    Check,
    ChevronsUpDown,
} from "lucide-react";

import { Input } from "../ui/input";

import { cn } from "@/lib/utils";

import { PurchaseProps } from "./types/purchase-types";
import { IAddPurchase } from "@/utils/schemas/purchase/add-purchase.scheme";

import { getContractors } from "@/utils/api/services/contractor.service";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

export default function Purchase({
    isOpen, 
    setIsOpen,
    itemsList,
}: PurchaseProps) {

    const [currentIndex, setCurrentIndex] = useState(1);
    const [currentItem, setCurrentItem] = useState(itemsList[0]);
    const [errMessage, setErrMessage] = useState("");
    const [buttonText, setButtonText] = useState("К следующему товару");
    const [isPopoverOpen, setIsPopoverOpen] = useState(false);  
    const [contractorsArr, setContractorsArr] = useState<IContractorResponse[]>([]);
    const purchaseForm = useForm<IAddPurchase>({});

    useEffect(() => {
        getAllContractors();
        console.log("cont: ", contractorsArr);
    });
    

    async function getAllContractors() {                  //получение всех подрядчиков
        const contractors = await getContractors();
        setContractorsArr(contractors);
    }

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
            <DialogContent className="max-w-[700px]">
                <DialogHeader className="">
                    <DialogTitle className="mx-auto mb-[30px] text-2xl">{currentItem ? currentItem.title : errMessage}</DialogTitle>
                </DialogHeader>

                    <Form {...purchaseForm}>
                        <form 
                            className="flex flex-col gap-4 " 
                            onSubmit={purchaseForm.handleSubmit(handleFormSubmit)}
                        >
                            <div className="flex justify-between mb-[100px]">
                                <FormField
                                    control={purchaseForm.control}
                                    name="quantity"
                                    defaultValue=""
                                    render={({ field }) => (
                                        <FormItem>
                                            <div className="flex items-center gap-[15px]">
                                                <FormLabel>Количество закупаемого товара</FormLabel>
                                                <FormControl>
                                                    <Input {...field} className="w-[60px]"/>
                                                </FormControl>
                                            </div>
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={purchaseForm.control}
                                    name="contractor"
                                    defaultValue=""
                                    render={({ field }) => (
                                        <FormItem className="flex flex-col w-[200px]">
                                            {/* <FormLabel>Подрядчик</FormLabel> */}
                                            <Popover open={isPopoverOpen} onOpenChange={setIsPopoverOpen}>
                                                <PopoverTrigger asChild>
                                                    <FormControl>
                                                        <Button
                                                            variant="outline"
                                                            role="combobox"
                                                            className={cn("justify-between", !field.value && "text-muted-foreground")}
                                                        >
                                                            {field.value
                                                            ? contractorsArr.find(
                                                                (contractor) =>
                                                                    contractor.name === field.value
                                                            )?.name
                                                            : "Выбрать подрядчика"}
                                                            <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
                                                        </Button>
                                                    </FormControl>
                                                </PopoverTrigger>
                                                <PopoverContent className="w-[var(--radix-popover-trigger-width)] max-h-[var(--radix-popover-content-available-height)] p-0">
                                                    <Command>
                                                        <CommandInput
                                                            className="border-none focus-visible:ring-ring focus-visible:ring-offset-2"
                                                            placeholder="Поиск типа..."
                                                        />
                                                        <CommandEmpty>Подрядчик не найден.</CommandEmpty>
                                                        <CommandGroup>
                                                            {contractorsArr.map((contractor) => (
                                                            <CommandItem
                                                                value={contractor.name}
                                                                key={contractor.name}
                                                                onSelect={() => {
                                                                    purchaseForm.setValue("contractor", contractor.name);
                                                                    setIsPopoverOpen(false);
                                                                }}
                                                            >
                                                                <Check className={cn("mr-2 h-4 w-4", contractor.name === field.value ? "opacity-100" : "opacity-0")} />
                                                                {contractor.name}
                                                            </CommandItem>
                                                            ))}
                                                        </CommandGroup>
                                                    </Command>
                                                </PopoverContent>
                                            </Popover>
                                        </FormItem>
                                    )}
                                />
                            </div>
                            <Button type="submit" className="w-[200px]">{buttonText}</Button>
                        </form>
                    </Form>
                    {/* <DialogDescription>{errMessage}</DialogDescription> */}
            </DialogContent>
        </Dialog>
    );
} 