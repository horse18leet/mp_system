import { 
    Eye, 
    EyeOff, 
    Grip  
} from "lucide-react";
import { Button } from "../ui/button";
import { useState } from "react";

import { useDrag, useDrop } from 'react-dnd';
import { IMediaItem } from "@/common/utils/schemas/item-info/media-item/media-item.scheme";


interface MediaWrapperProps {
    media: IMediaItem;
    moveMedia: any;
    index: number;
}

export default function MediaWrapper({media, moveMedia, index} : MediaWrapperProps) {
    const [isEye, setIsEye] = useState(true);

    const [, drop] = useDrop<{ id: number, index: number }>({
        accept: 'media',
        hover(item, monitor) {
            if (item.index === index) return;
            moveMedia(item.index, index);
            item.index = index;
        },
    });
    
    const [{ isDragging }, drag, preview] = useDrag({
        type: 'media',
        item: () => ({ id: media.id, index }),
        collect: (monitor) => ({
            isDragging: monitor.isDragging(),
            dragPreviewStyle: {
                opacity: 1,
            },
        }),
    });

    const handleEyeButtonClick = () => {
        setIsEye(!isEye);
    }


    return (
        <div ref={drop} className="w-full h-full relative">
            <div ref={preview} className="absolute top-0 right-0 z-50">
                <Button className="rounded-none bg-black bg-opacity-50 hover:bg-opacity-70 hover:bg-black w-min h-min p-[4px]" onClick={handleEyeButtonClick}>
                    {
                        isEye ? <Eye/> : <EyeOff/>
                    }
                </Button>
                <Button ref={drag} className="cursor-move rounded-none bg-black bg-opacity-50 hover:bg-opacity-70 hover:bg-black w-min h-min p-[4px]">
                    <Grip/>
                </Button>
            </div>
            <div ref={preview} className="w-full h-full border border-white"> 
            {
                media.type === "photo" ?
                <img src={media.src} className="object-cover h-full" />
                :
                <video src={media.src} className="object-cover h-full" controls preload="metadata" />
            }
            </div>
        </div>
    )
}