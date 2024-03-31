interface IItemRequest {
    id: number;
    title: string;
    description: string;
    firstPrice: string;
    user: string; // в будущем заменить на тип User
    category: string;
    vendorCode: string;
    mpLink: string;
    isDraft: boolean;
    isActive: boolean;
    createdAt: string;
}

export default IItemRequest;