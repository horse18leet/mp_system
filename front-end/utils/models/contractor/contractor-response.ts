interface IContractorResponse {
    id: number;
    name: string;
    type: string;
    description: string;
    email: string;
    actualAddress: string;
    isActive: boolean;
    createdAt: string;
<<<<<<< Updated upstream
    // phoneNumber: string;
=======
    phoneNum: string;
>>>>>>> Stashed changes
    paymentNum: string;
}

export default IContractorResponse;