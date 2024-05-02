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
import { CalendarIcon } from '@radix-ui/react-icons'

import { Input } from "../ui/input";
import { Calendar } from "@/components/ui/calendar"

import { cn } from "@/lib/utils";
import { format } from "date-fns"

import { PurchaseProps } from "./types/purchase-types";
import { IAddPurchase } from "@/utils/schemas/purchase/add-purchase.scheme";

import { getContractors } from "@/utils/api/services/contractor.service";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

export default function Purchase({
    isOpen, 
    setIsOpen,
    itemsList,
}: PurchaseProps) {

    const [date, setDate] =useState<Date | undefined>(new Date());
    const [currentIndex, setCurrentIndex] = useState(1);
    const [currentItem, setCurrentItem] = useState(itemsList[0]);
    const [errMessage, setErrMessage] = useState("");
    const [buttonText, setButtonText] = useState("К следующему товару");
    const [isPopoverOpen, setIsPopoverOpen] = useState(false);  
    const [contractorsArr, setContractorsArr] = useState<IContractorResponse[]>([]);
    const purchaseForm = useForm<IAddPurchase>({});

    useEffect(() => {
        getAllContractors();
    });
    

    async function getAllContractors() {                  //получение всех подрядчиков
        const contractors = await getContractors();
        setContractorsArr(contractors);
    }

    function handleFormSubmit() {           //временно
        
    }
    
    function handleNextItem() {
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
            <DialogContent className="max-w-[500px]">
                <DialogHeader className="">
                    <DialogTitle className="mx-auto mb-[30px] text-2xl">{currentItem ? currentItem.title : errMessage}</DialogTitle>
                </DialogHeader>

                    <Form {...purchaseForm}>
                        <form 
                            className="flex flex-col gap-4 " 
                            onSubmit={purchaseForm.handleSubmit(handleFormSubmit)}
                        >
                            <div className="flex flex-col mb-[50px] gap-y-[30px]">
                                <FormField
                                    control={purchaseForm.control}
                                    name="contractor"
                                    defaultValue=""
                                    render={({ field }) => (
                                        <FormItem className="flex flex-col w-[200px]">
                                            <FormLabel>Подрядчик</FormLabel>
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
                                                            placeholder="Поиск подрядчика..."
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
                                <FormField
                                    control={purchaseForm.control}
                                    name="quantity"
                                    defaultValue=""
                                    render={({ field }) => (
                                        <FormItem>
                                            <FormLabel>Количество закупаемого товара</FormLabel>
                                            <FormControl>
                                                <Input {...field} className="w-[100px]"/>
                                            </FormControl>
                                        </FormItem>
                                    )}
                                />

                                <FormField
                                    control={purchaseForm.control}
                                    name="price"
                                    defaultValue=""
                                    render={({ field }) => (
                                        <FormItem>
                                            <FormLabel>Стоимость</FormLabel>
                                            <FormControl>
                                                <Input  {...field} className="w-[100px]"/>
                                            </FormControl>
                                        </FormItem>
                                    )}
                                />
                                <FormField
                                    control={purchaseForm.control}
                                    name="date"
                                    defaultValue=""
                                    render={({ field }) => (
                                        <FormItem>
                                            <div className="flex flex-col">
                                                <FormLabel>Дата окончания работ</FormLabel>
                                                    <Popover>
                                                        <PopoverTrigger asChild>
                                                            <FormControl>
                                                                <Button
                                                                    variant={"outline"}
                                                                    className={cn("w-[240px] justify-start text-left font-normal mt-[12px]", !field.value && "text-muted-foreground")}
                                                                >
                                                                    <CalendarIcon className="mr-2 h-4 w-4" />
                                                                    {field.value ? format(field.value, "PPP") : <span>Выбрать дату</span>}
                                                                </Button>
                                                            </FormControl>
                                                        </PopoverTrigger>
                                                        <PopoverContent className="w-auto p-0" align="start">
                                                            <Calendar
                                                                mode="single"
                                                                selected={field.value}
                                                                onSelect={field.onChange}
                                                                initialFocus
                                                            />
                                                        </PopoverContent>
                                                    </Popover>
                                            </div>
                                        </FormItem>
                                    )}
                                />
                            </div>
                            <div className="flex">
                                <Button type="submit" className="w-[200px]">Добавить подрядчика</Button>
                                {/* <Button variant="secondary" className="w-[200px]" onClick={handleNextItem}>{buttonText}</Button> */}
                            </div>
                            

                        </form>
                    </Form>
                    {/* <DialogDescription>{errMessage}</DialogDescription> */}
            </DialogContent>
        </Dialog>
    );
} 