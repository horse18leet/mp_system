import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
  } from "@/common/components/ui/card";

import { IAttributeItem } from "@/common/utils/schemas/item-info/attribute-item/attribute-item.scheme";
import { Input } from "../ui/input";
import FileUploader from "../FileUploader/FileUploader";
import { useCallback, useState } from "react";
import { IMediaItem } from "@/common/utils/schemas/item-info/media-item/media-item.scheme";
import MediaWrapper from "../MediaWrapper/MediaWrapper";

import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";
import DragAndDropGallery from "../DragAndDropGallery/DragAndDropGallery";
import DndWrapper from "../DndWrapper/DndWrapper";

interface ItemVariantProps {
    attributesArr: IAttributeItem[];
    dndId: number;
}

export default function ItemVariant({ attributesArr, dndId }: ItemVariantProps) {
    const [attrMediaArr, setAttrMediaArr] = useState<IMediaItem[]>([
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
    ])

    return (
        <Card className="w-[100%]">
            <CardHeader>
                <CardTitle className="text-lg">Атрибуты товара данной подкатегории</CardTitle>
            </CardHeader>
            <CardContent>
                <ul className="flex flex-row flex-wrap justify-between gap-[30px] mb-[50px]">
                    {
                        attributesArr.map((attribute: any) => (
                            <li className="w-[350px]" key={attribute.id}>
                                <Card className="border-white px-[20px]">
                                    <CardContent className=" h-[60px] p-0 flex items-center justify-between">
                                        <h3>{attribute.name}</h3>
                                        <Input className="w-[120px] h-[40px]" />
                                    </CardContent>
                                </Card>
                            </li>
                        ))
                    }
                </ul>
                <div className="flex justify-between" id={`itemInfovVar${dndId}`}>
                    <DndWrapper id={`itemInfovVar${dndId}`}>
                        <DragAndDropGallery itemsArr={attrMediaArr} containerClassName="w-[82%] list-none m-0 p-0 grid grid-cols-3 gap-[15px]" />
                    </DndWrapper>
                    <div className="w-[200px]">
                        <FileUploader allowedFormat="image/*, video/*" handleUpload={()=>{}} />
                    </div>
                </div>
            </CardContent>
        </Card>
    )
}