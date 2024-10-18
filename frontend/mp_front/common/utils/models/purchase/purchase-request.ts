import { IPurchaseContractor } from "@/common/utils/schemas/purchase/purchase-contractor/purchase-contractor.scheme";

interface IPurchaseRequest {
    purchaseId?: number;
    itemId: number;
    quantity: number;
    contractorsWork: IPurchaseContractor[];
}

export default IPurchaseRequest;