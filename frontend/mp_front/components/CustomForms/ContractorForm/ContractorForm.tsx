import { IAddContractor, addContractorScheme } from "@/utils/schemas/contractor/add-contractor.scheme";

import { AxiosError } from "axios";
import { joiResolver } from "@hookform/resolvers/joi";

import { useForm } from "react-hook-form";
import { useState } from "react";

import { ContractorFormProps } from "./types/contractor-form-props";
import { createContractor, editContractor } from "@/utils/api/services/contractor.service";

import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form";
import { Check, ChevronsUpDown } from "lucide-react";
import { cn } from "@/lib/utils";

import {
    Popover,
    PopoverContent,
    PopoverTrigger,
} from "@/components/ui/popover";

import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";

import {
    Command,
    CommandEmpty,
    CommandGroup,
    CommandInput,
    CommandItem,
} from "@/components/ui/command";
import { IEditContractor } from "@/utils/schemas/contractor/edit-contractor.sheme";


export default function ContractorForm({
    contractor,
    isEdit,
    handleFormSubmit,

}: ContractorFormProps) {
    const [contractorTypes, setContractorTypes] = useState(["Поставщик", "Реклама", "Фулфилмент", "Байер"]); 

    const [popoverOpen, setPopoverOpen] = useState(false);


    const contractorForm = useForm<IAddContractor | IEditContractor>({
        resolver: joiResolver(addContractorScheme),
    });

   

    return (
        <Form {...contractorForm}>
            <form 
                className="flex flex-col gap-4" 
                onSubmit={contractorForm.handleSubmit(handleFormSubmit)}
            >
                <FormField
                    control={contractorForm.control}
                    name="name"
                    defaultValue= {!isEdit ? "" : contractor.name}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Название</FormLabel>
                            <FormControl>
                                <Input placeholder="Введите название..." {...field} />
                            </FormControl>
                            <FormDescription />
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <FormField
                    control={contractorForm.control}
                    name="type"
                    defaultValue=""
                    render={({ field }) => (
                        <FormItem className="flex flex-col">
                            <FormLabel>Категория</FormLabel>
                            <Popover open={popoverOpen} onOpenChange={setPopoverOpen}>
                                <PopoverTrigger asChild>
                                    <FormControl>
                                        <Button
                                            variant="outline"
                                            role="combobox"
                                            className={cn("justify-between", !field.value && "text-muted-foreground")}
                                        >
                                        {field.value
                                        ? contractorTypes.find(
                                            (contractorType) =>
                                                contractorType === field.value
                                        )
                                        : "Выберите категорию подрядчика"}
                                            <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
                                        </Button>
                                    </FormControl>
                                </PopoverTrigger>
                                <PopoverContent className="w-[var(--radix-popover-trigger-width)] max-h-[var(--radix-popover-content-available-height)] p-0">
                                    <Command>
                                        <CommandInput
                                            className="border-none focus-visible:ring-ring focus-visible:ring-offset-2"
                                            placeholder="Поиск категории..."
                                        />
                                        <CommandEmpty>Категория не найдена.</CommandEmpty>
                                        <CommandGroup>
                                            {contractorTypes.map((contractorType) => (
                                            <CommandItem
                                                value={contractorType}
                                                key={contractorType}
                                                onSelect={() => {
                                                contractorForm.setValue("type", contractorType);
                                                setPopoverOpen(false);
                                            }}
                                            >
                                                <Check className={cn("mr-2 h-4 w-4", contractorType === field.value ? "opacity-100" : "opacity-0")} />
                                                {contractorType}
                                            </CommandItem>
                                            ))}
                                        </CommandGroup>
                                    </Command>
                                </PopoverContent>
                            </Popover>
                        </FormItem>
                    )}
                />
                <div className="grid grid-cols-2 gap-4">
                    <FormField
                        control={contractorForm.control}
                        name="email"
                        defaultValue={!isEdit ? "" : contractor.email}
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>E-mail</FormLabel>
                                <FormControl>
                                    <Input {...field} />
                                </FormControl>
                            </FormItem>
                        )}
                    />
                                        {/* <FormField
                                            control={addContractorForm.control}
                                            name="phoneNum"
                                            render={({ field }) => (
                                            <FormItem>
                                                <FormLabel>Номер телефона</FormLabel>
                                                <FormControl>
                                                    <Input {...field} />
                                                </FormControl>
                                            </FormItem>
                                            )}
                                        /> */}
                </div>
                <FormField
                    control={contractorForm.control}
                    name="description"
                    defaultValue={!isEdit ? "" : contractor.description}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Описание</FormLabel>
                            <FormControl>
                                <Textarea placeholder="Напишите описание подрядчика..." {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={contractorForm.control}
                    name="actualAddress"
                    defaultValue={!isEdit ? "" : contractor.actualAddress}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Адрес подрядчика</FormLabel>
                            <FormControl>
                                <Input placeholder="Введите адрес..." {...field} />
                            </FormControl>
                            <FormDescription />
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <FormField
                    control={contractorForm.control}
                    name="paymentNum"
                    defaultValue={!isEdit ? "" : contractor.paymentNum}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Платежные данные</FormLabel>
                            <FormControl>
                                <Input placeholder="Введите номер карты..." {...field} />
                            </FormControl>
                            <FormDescription />
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <Button type="submit">Добавить</Button>
            </form>
        </Form>
    );
}