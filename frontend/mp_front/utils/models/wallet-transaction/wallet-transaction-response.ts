interface IWalletTransactionResponse {
    id: number;
    amount: number;
    description: string;
    // implDate: string;
    createdAt: string;
    contractorDto: any;
};

export default IWalletTransactionResponse;