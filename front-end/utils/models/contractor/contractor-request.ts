interface IContractorRequest {
    id?: number;
    name: string;
    type: string;
    description: string;
    email: string;
    actualAddress: string;
    // phoneNumber: string;
    paymentNum: string;
    isActive?: boolean;
    createdAt?: string;

}

export default IContractorRequest;