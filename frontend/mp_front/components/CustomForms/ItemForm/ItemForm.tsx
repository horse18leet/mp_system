import { IAddItem, addItemScheme } from "@/utils/schemas/item/add-item.scheme";

import { joiResolver } from "@hookform/resolvers/joi";

import { useForm } from "react-hook-form";
import { useState } from "react";

import { ItemFormProps } from "./types/item-form-props";

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

export default function ItemForm({
    item,
    isEdit,
    handleFormSubmit,

}: ItemFormProps) {
    const categories = [
        { value: "Обувь" },
        { value: "Верхняя одежда" },
        { value: "Брюки" },
        { value: "Электроника" },
      ] as const;

    const [isPopoverOpen, setIsPopoverOpen] = useState(false);


    const itemForm = useForm<IAddItem>({
        resolver: joiResolver(addItemScheme),
    });

   

    return (
        <Form {...itemForm}>
            <form 
                className="flex flex-col gap-4" 
                onSubmit={itemForm.handleSubmit(handleFormSubmit)}
            >
                <FormField
                    control={itemForm.control}
                    name="title"
                    defaultValue= {!isEdit ? "" : item.title}
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
                    control={itemForm.control}
                    name="category"
                    defaultValue={!isEdit ? "" : item.category}
                    render={({ field }) => (
                        <FormItem className="flex flex-col">
                            <FormLabel>Категория</FormLabel>
                            <Popover open={isPopoverOpen} onOpenChange={setIsPopoverOpen}>
                                <PopoverTrigger asChild>
                                    <FormControl>
                                        <Button
                                            variant="outline"
                                            role="combobox"
                                            className={cn("justify-between", !field.value && "text-muted-foreground")}
                                        >
                                        {field.value
                                        ? categories.find(
                                            (category) =>
                                                category.value === field.value
                                        )?.value
                                        : "Выберите категорию"}
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
                                            {categories.map((category) => (
                                            <CommandItem
                                                value={category.value}
                                                key={category.value}
                                                onSelect={() => {
                                                itemForm.setValue("category", category.value);
                                                setIsPopoverOpen(false);
                                            }}
                                            >
                                                <Check className={cn("mr-2 h-4 w-4", category.value === field.value ? "opacity-100" : "opacity-0")} />
                                                {category.value}
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
                        control={itemForm.control}
                        name="firstPrice"
                        defaultValue={!isEdit ? "" : item.firstPrice}
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Первичная цена</FormLabel>
                                <FormControl>
                                    <Input {...field} />
                                </FormControl>
                            </FormItem>
                        )}
                    />
                </div>
                <FormField
                    control={itemForm.control}
                    name="description"
                    defaultValue={!isEdit ? "" : item.description}
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Описание</FormLabel>
                            <FormControl>
                                <Textarea placeholder="Придумайте описание вашего товара..." {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <Button type="submit">Добавить</Button>
            </form>
        </Form>
    );
}