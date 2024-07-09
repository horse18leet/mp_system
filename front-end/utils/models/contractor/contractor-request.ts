interface IContractorRequest {
    id?: number;
    name: string;
    type: string;
    description: string;
<<<<<<< Updated upstream
    email: string;
    actualAddress: string;
    // phoneNumber: string;
    paymentNum: string;
    isActive?: boolean;
    createdAt?: string;

=======
    phoneNum: string;
    email: string;
    actualAddress: string;
    paymentNum: string;
    isActive?: boolean;
    createdAt?: string;
>>>>>>> Stashed changes
}

export default IContractorRequest;