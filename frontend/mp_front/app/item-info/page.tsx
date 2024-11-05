"use client";

import ProtectedLayout from "@/common/components/ProtectedLayout/ProtectedLayout";
import { Input } from "@/common/components/ui/input";
import { 
    Command,
    CommandInput,
    CommandList,
    CommandSeparator,
    CommandItem,
    CommandGroup,
    CommandEmpty
} from "@/common/components/ui/command";
import { Button } from "@/common/components/ui/button";
import FileUploader from "@/common/components/FileUploader/FileUploader";

export default function ItemInfo() {

    const mediaArr = [
        {
            id: 1,
            type: "photo",
            src: "test"
        },
        {
            id: 2,
            type: "photo",
            src: "test"
        },
        {
            id: 3,
            type: "video",
            src: "test"
        },
        {
            id: 4,
            type: "photo",
            src: "test"
        },
        {
            id: 5,
            type: "photo",
            src: "test"
        },
        {
            id: 6,
            type: "photo",
            src: "test"
        },
        {
            id: 7,
            type: "photo",
            src: "test",
        },
    ]

    return (
        <>
            <ProtectedLayout>
                <div className="container pt-8 h-full mb-[50px]">
                    <h1 className="text-2xl font-bold tracking-tight mb-[20px]">Учет товаров (создание карточки товара)</h1>
                    <p className="mb-[40px]">Ошибка синхронизации с маркетплейсами (заполните следующие поля: название, цена)</p>
                    <div className="w-[100%] flex flex-row items-center ml-[auto] mr-[auto] gap-[20px] mb-[20px]">
                        {/* <Input type="text" placeholder="Название товара" className="h-[50px] mb-[40px]" />
                        <div className="w-[100%] flex flex-row justify-between">
                            <Button variant="outline">Добавить вариант товара</Button>
                            <p>Товар синхронизирован сегодня в 20:36</p>
                        </div> */}
                        <Button variant="default">Начать синхронизацию</Button>
                        <Button variant="default">Сохранить</Button>
                        <Button variant="default" className="bg-red-400">Добавить в анализ</Button>
                        <Button variant="default" className="ml-auto w-[205px]">Перенести в архив</Button>
                    </div>
                    <div className="flex mb-[40px]">
                        <Input type="text" placeholder="Название товара" className="w-[40%] text-black" />
                        {/* <Command className="rounded-lg border shadow-md md:min-w-[450px]">
                            <CommandInput placeholder="Type a command or search..." />
                            <CommandList>
                                <CommandEmpty>No results found.</CommandEmpty>
                                <CommandGroup heading="Suggestions">
                                <CommandItem>
                                    <span>Calendar</span>
                                </CommandItem>
                                <CommandItem>
                                    <span>Search Emoji</span>
                                </CommandItem>
                                <CommandItem disabled>
                                    <span>Launch</span>
                                </CommandItem>
                                </CommandGroup>
                                <CommandSeparator />
                                <CommandGroup heading="Settings">
                                <CommandItem>
                                    <span>Profile</span>
                                </CommandItem>
                                <CommandItem>
                                    <span>Mail</span>
                                </CommandItem>
                                <CommandItem>
                                    <span>Settings</span>
                                </CommandItem>
                                </CommandGroup>
                            </CommandList>
                        </Command> */}
                    </div>
                    <div className="w-[100%]">
                        <h2 className="text-xl font-bold tracking-tight mb-[20px]">Медиа</h2>
                        <div className="flex justify-between">
                            <ul className="w-[82%] list-none m-0 p-0 grid grid-cols-6 gap-[34px] ">
                                {
                                    mediaArr.map((media) => (
                                        
                                        <li className="m-0 p-0 border border-white w-[153px] h-[195px]" key={media.id}>
                                            {
                                                media.type === "photo" ?
                                                <img src={media.src} />
                                                :
                                                <video src={media.src} />
                                            }
                                        </li>
                                    ))
                                }
                            </ul> 
                            <FileUploader allowedFormat="image/*, video/*" />
                        </div>
                        <div className="mt-[40px]">
                                <h2 className="text-xl font-bold tracking-tight mb-[20px]">Варианты товара</h2>
                        </div>
                    </div>
                </div>
            </ProtectedLayout>
        </>
        
    );
}