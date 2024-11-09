"use client";

import ProtectedLayout from "@/common/components/ProtectedLayout/ProtectedLayout";
import { Input } from "@/common/components/ui/input";
import { StaticImageData } from "next/image";

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
import MediaWrapper from "@/common/components/MediaWrapper/MediaWrapper";

import { DndProvider } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';
import { 
    useState, 
    useCallback  
} from "react";

interface MediaItem {
    id: number;
    type: "photo" | "video";
    src: string;
}


export default function ItemInfo() {
    const [mediaArr, setMediaArr] = useState<MediaItem[]>([
        {
            id: 1,
            type: "photo",
            src: "https://djimsk.ru/guides/wp-content/uploads/2022/02/20190412_122232-2048x1536.jpeg"
        },
        {
            id: 2,
            type: "photo",
            src: "https://djimsk.ru/guides/wp-content/uploads/2022/02/20190412_122232-2048x1536.jpeg"
        },
        {
            id: 3,
            type: "video",
            src: "https://static.vecteezy.com/system/resources/previews/009/420/470/mp4/drone-flying-low-over-sea-mikra-strava-greece-free-video.mp4"
        },
        {
            id: 4,
            type: "photo",
            src: "https://djimsk.ru/guides/wp-content/uploads/2022/02/20190412_122232-2048x1536.jpeg"
        },
        {
            id: 5,
            type: "photo",
            src: "https://djimsk.ru/guides/wp-content/uploads/2022/02/20190412_122232-2048x1536.jpeg"
        },
        {
            id: 6,
            type: "photo",
            src: "https://djimsk.ru/guides/wp-content/uploads/2022/02/20190412_122232-2048x1536.jpeg"
        },
        {
            id: 7,
            type: "video",
            src: "https://static.vecteezy.com/system/resources/previews/009/420/470/mp4/drone-flying-low-over-sea-mikra-strava-greece-free-video.mp4"
        },
    ]);

    const moveMedia = useCallback(
        (dragIndex: number, hoverIndex: number) => {
            const dragMedia = mediaArr[dragIndex];
            setMediaArr((prevMediaArr) => {
                const newMediaArr = [...prevMediaArr];
                newMediaArr.splice(dragIndex, 1);
                newMediaArr.splice(hoverIndex, 0, dragMedia);
                return newMediaArr;
            });
        },
        [mediaArr, setMediaArr]
    );

    

    return (
        <>
            <ProtectedLayout>
                <DndProvider backend={HTML5Backend}>
                    <div className="container pt-8 h-full mb-[50px]">
                        <h1 className="text-2xl font-bold tracking-tight mb-[20px]">Учет товаров (создание карточки товара)</h1>
                        <p className="mb-[40px]">Ошибка синхронизации с маркетплейсами (заполните следующие поля: название, цена)</p>
                        <ul className="list-none w-[100%] flex flex-row items-center ml-[auto] mr-[auto] gap-[20px] mb-[20px]">
                            <li><Button variant="default">Начать синхронизацию</Button></li>
                            <li><Button variant="default">Сохранить</Button></li>
                            <li><Button variant="secondary">Добавить в анализ</Button></li>
                            <li className="ml-auto "><Button variant="default">Перенести в архив</Button></li>
                        </ul>
                        <div className="flex mb-[40px]">
                            <Input type="text" placeholder="Название товара" className="w-[40%] text-white" />
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
                                        mediaArr.map((media, index) => (    
                                            
                                            <li className="m-0 p-0 border border-white w-[153px] h-[195px]" key={media.id}>
                                                <MediaWrapper media={media} index={index} moveMedia={moveMedia} />
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
                </DndProvider>
            </ProtectedLayout>
        </>
        
    );
}