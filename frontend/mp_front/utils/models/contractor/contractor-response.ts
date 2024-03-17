interface IContractorResponse {
    id: number;
    name: string;
    type: string;
    description: string;
    email: string;
    actualAddress: string;
    isActive: boolean;
    createdAt: string;
    // phoneNumber: string;
    cardNum: string;
}

export default IContractorResponse;