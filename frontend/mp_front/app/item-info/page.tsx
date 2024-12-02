"use client";

import { 
    useState, 
    useCallback  
} from "react";

import ProtectedLayout from "@/common/components/ProtectedLayout/ProtectedLayout";
import FileUploader from "@/common/components/FileUploader/FileUploader";
import MediaWrapper from "@/common/components/MediaWrapper/MediaWrapper";
import ItemVariant from "@/common/components/ItemInfoComponents/ItemVariant/ItemVariant";
import Marking from "@/common/components/ItemInfoComponents/Marking/Marking";

import { IAttributeItem } from "@/common/utils/schemas/item-info/attribute-item/attribute-item.scheme";
import { IMediaItem } from "@/common/utils/schemas/item-info/media-item/media-item.scheme";
import {
    Select,
    SelectContent,
    SelectGroup,
    SelectItem,
    SelectLabel,
    SelectTrigger,
    SelectValue,
} from "@/common/components/ui/select"
import { Input } from "@/common/components/ui/input";
import { Button } from "@/common/components/ui/button";
import { Textarea } from "@/common/components/ui/textarea";


import DragAndDropGallery from "@/common/components/DragAndDropGallery/DragAndDropGallery";
import DndWrapper from "@/common/components/DndWrapper/DndWrapper";

export default function ItemInfo() {
    const [currencyArr, setCurrencyArr] = useState<string[]>(["Рубль (₽)", "Доллар ($)", "Евро (€)"]);
    const [ndsArr, setNdsArr] = useState<string[]>(["228", "337", "322"]);
    const [variants, setVariants] = useState<any>([]);
    const [mediaArr, setMediaArr] = useState<IMediaItem[]>([
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

    const [attributesArr, setAttributesArr] = useState<IAttributeItem[]>([
        {
            id: 1,
            name: "цвет",
        },
        {
            id: 2,
            name: "мощность",
        },
        {
            id: 3,
            name: "масса",
        },
        {
            id: 4,
            name: "скорость",
        },
    ])

    function addVariant() {
        const newVariant = { id: Date.now(), attributesArr: attributesArr };
        setVariants([...variants, newVariant]);
    };


    return (
        <ProtectedLayout>
                <div className="container pt-8 h-full mb-[50px]">
                    <h1 className="text-2xl font-bold tracking-tight mb-[20px]">Учет товаров (создание карточки товара)</h1>
                    <p className="mb-[40px]">Ошибка синхронизации с маркетплейсами (заполните следующие поля: название, цена)</p>
                    <ul className="list-none w-[100%] flex flex-row items-center ml-[auto] mr-[auto] gap-[20px] mb-[20px]">
                        <li><Button variant="default">Сохранить</Button></li>
                        <li><Button variant="secondary">Добавить в анализ</Button></li>
                        <li><Button variant="default">Перенести в архив</Button></li>
                        <li className="ml-auto"><Button variant="default">Синхронизация</Button></li>
                    </ul>
                    <ul className="flex flex-col p-0 mb-[40px] w-[50%] gap-[20px]">
                        <li>
                            <Input type="text" placeholder="Название товара"  />
                        </li>
                        <li>
                            <Select>
                                <SelectTrigger className="w-[100%]">
                                    <SelectValue placeholder="Категория товара" />
                                </SelectTrigger>
                                <SelectContent>
                                    <SelectGroup>
                                        <SelectLabel>Категории</SelectLabel>
                                        <SelectItem value="wear">Одежда</SelectItem>
                                        <SelectItem value="food">Еда</SelectItem>
                                        <SelectItem value="sport">Спорт</SelectItem>
                                        <SelectItem value="tech">Техника</SelectItem>
                                    </SelectGroup>
                                </SelectContent>
                            </Select>
                        </li>
                        <li>
                            
                        </li>
                    </ul>
                    <div className="w-[100%]">
                        <h2 className="text-xl font-bold tracking-tight mb-[20px]">Медиа</h2>
                        <div className="flex justify-between mb-[40px]" id={"itemInfoGallery"}>
                            <DndWrapper id={"itemInfoGallery"}>
                                <DragAndDropGallery itemsArr={mediaArr} containerClassName="w-[82%] list-none m-0 p-0 grid grid-cols-6 gap-[34px]" />
                            </DndWrapper>
                            <FileUploader allowedFormat="image/*, video/*" handleUpload={()=>{}} />

                        </div>
                        <div className="w-[60%] mb-[40px] flex flex-col gap-[20px]">
                            <div  className="flex justify-between">
                                <h2 className="text-xl font-bold tracking-tight mb-[20px]">Варианты товара</h2>
                                <Button onClick={addVariant}>Добавить вариант товара</Button>
                            </div>
                            <ItemVariant attributesArr={attributesArr} dndId={0}/>
                            {
                                variants.map((variant: any) => (
                                    <ItemVariant key={variant.id} attributesArr={variant.attributesArr} dndId={variant.id} />
                                ))
                            } 
                        </div>
                        <div className="flex justify-between mb-[40px]">
                            <div className="mr-[30px] flex flex-col gap-[15px]">
                                <Input placeholder="Цена" />
                                <Select>
                                    <SelectTrigger className="">
                                        <SelectValue placeholder="Валюта" />
                                    </SelectTrigger>
                                    <SelectContent>
                                        <SelectGroup>
                                            <SelectLabel>Валюта</SelectLabel>
                                            {
                                                currencyArr.map((currency, index) => (
                                                    <SelectItem value={currency} key={index}>{currency}</SelectItem>
                                                ))
                                            }
                                        </SelectGroup>
                                    </SelectContent>
                                </Select>
                                <Select>
                                    <SelectTrigger className="">
                                        <SelectValue placeholder="Ставка НДС" />
                                    </SelectTrigger>
                                    <SelectContent>
                                        <SelectGroup>
                                            <SelectLabel>Ставка НДС</SelectLabel>
                                            {
                                                ndsArr.map((nds, index) => (
                                                    <SelectItem value={nds} key={index}>{nds}</SelectItem>
                                                ))
                                            }
                                        </SelectGroup>
                                    </SelectContent>
                                </Select>
                            </div>
                            <Textarea placeholder="Описание товара" className="resize-none text-l" />
                        </div>
                    </div>
                    <div className="w-[100%]">
                        <Marking />
                    </div>
                </div>
        </ProtectedLayout>
    );
}