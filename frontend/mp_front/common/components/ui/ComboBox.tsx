"use client"

import * as React from "react"
import { CaretSortIcon, CheckIcon } from "@radix-ui/react-icons"

import { cn } from "@/lib/utils"
import { Button } from "@/common/components/ui/button"
import {
  Command,
  CommandEmpty,
  CommandGroup,
  CommandInput,
  CommandItem,
} from "@/common/components/ui/command"
import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from "@/common/components/ui/popover"
import { Check, ChevronsUpDown } from "lucide-react"

type Props = {
    list: any;
    notFoundMessage: string;
    title: string;
}

export function ComboBox({list, notFoundMessage, title}: Props) {
    const [open, setOpen] = React.useState(false)
    const [value, setValue] = React.useState(list[0].label)
   
    return (
      <Popover open={open} onOpenChange={setOpen}>
        <PopoverTrigger asChild>
          <Button
            variant="outline"
            role="combobox"
            aria-expanded={open}
            className="w-[200px] justify-between"
          >
            {value}
            <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
          </Button>
        </PopoverTrigger>
        <PopoverContent className="w-[200px] p-0">
          <Command>
            <CommandGroup>
              {list.map((item: { value: string, label: string }) => (
                <CommandItem
                  key={item.value}
                  value={item.value}
                  onSelect={(currentValue) => {
                    setValue(currentValue === value ? "" : currentValue)
                    setOpen(false)
                  }}
                >
                  <Check
                    className={cn(
                      "mr-2 h-4 w-4",
                      value === item.value ? "opacity-100" : "opacity-0"
                    )}
                  />
                  {item.label}
                </CommandItem>
              ))}
            </CommandGroup>
          </Command>
        </PopoverContent>
      </Popover>
    )
  }

  /**
   {value
              ? list.find((item: { value: string, label: string }) => item.value === value)?.label
              : `${title}`}
   */