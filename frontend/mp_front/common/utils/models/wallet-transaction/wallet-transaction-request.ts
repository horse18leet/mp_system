interface IWalletTransactionRequest {
    amount: number;
    description: string;
    type: string;
    contractorDto: any;  //пока так
    itemDto: any;
};

export default IWalletTransactionRequest;