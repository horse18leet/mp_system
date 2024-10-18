import { IAddContractor } from "@/common/utils/schemas/contractor/add-contractor.scheme";
import { IEditContractor } from "@/common/utils/schemas/contractor/edit-contractor.sheme";
import { IAddItem } from "@/common/utils/schemas/item/add-item.scheme";

export interface ContractorFormProps {
    contractor?: IAddContractor | any;   //пока так
    isEdit: boolean;
    handleFormSubmit: (data: IAddContractor | IEditContractor | any) => Promise<void>;          //пока так
}