interface IWalletTransactionResponse {
    id: number;
    amount: number;
    description: string;
    type: string;
    // implDate: string;
    createdAt: string;
    contractorDto?: any;
    itemDto?: any;
};

export default IWalletTransactionResponse;