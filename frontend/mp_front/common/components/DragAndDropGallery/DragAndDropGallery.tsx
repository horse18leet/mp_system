import { 
    useState, 
    useCallback 
} from "react";

import { DndProvider } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';

import MediaWrapper from "../MediaWrapper/MediaWrapper";

interface DragAndDropGalleryProps {
    itemsArr: any[];
    containerClassName: string;
}

export default function DragAndDropGallery({ itemsArr, containerClassName }: DragAndDropGalleryProps) {
    const [dragItems, steDragItems] = useState(itemsArr);

    const moveItem = useCallback(
        (dragIndex: number, hoverIndex: number) => {
            const dragItem = dragItems[dragIndex];
            steDragItems((prevDragArr) => {
                const newDragArr = [...prevDragArr];
                newDragArr.splice(dragIndex, 1);
                newDragArr.splice(hoverIndex, 0, dragItem);
                return newDragArr;
            });
        },
        [dragItems, steDragItems]
    );
    
    return (
        <ul className={containerClassName}>
            {
                dragItems.map((item, index) => (    
                    <li className="m-0 p-0 border border-white w-[153px] h-[195px]" key={`${item.id + Date.now()}`}>
                        <MediaWrapper media={item} index={index} moveMedia={moveItem} />
                    </li>
                ))
            }
        </ul> 
    );
}