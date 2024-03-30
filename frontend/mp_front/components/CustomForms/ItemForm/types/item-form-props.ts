import { IAddContractor } from "@/utils/schemas/contractor/add-contractor.scheme";
import { IEditContractor } from "@/utils/schemas/contractor/edit-contractor.sheme";
import { IAddItem } from "@/utils/schemas/item/add-item.scheme";

export interface ItemFormProps {
    item?: IAddItem | any;   //пока так
    isEdit: boolean;
    handleFormSubmit: (data: IAddItem) => Promise<void>;          //пока так
}