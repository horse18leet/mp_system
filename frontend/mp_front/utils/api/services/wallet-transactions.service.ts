import api from "../api";
import { AxiosError, AxiosResponse } from "axios";

import IWalletTransactionResponse from "@/utils/models/wallet-transaction/wallet-transaction-response";
import IWalletTransactionRequest from "@/utils/models/wallet-transaction/wallet-transaction-request";

export async function getItemWalletTransactions(id: number): Promise<IWalletTransactionResponse[] | AxiosError | any> {
    try {
      const response = await api.get<IWalletTransactionResponse[]>(`/walletTransactions/item/${id}`);
      const data = response.data;
      console.log(data);
      return data;
  
    } catch (e) {
      const error = e as AxiosError;
      return error;
    }
}

export async function createWalletTransaction(id: number, walletTransaction: IWalletTransactionRequest): Promise<AxiosResponse | AxiosError> {
  try {
    const response = await api.post(`/walletTransactions/item/${id}`, walletTransaction);
    const data = response.data;

    return data;

  } catch (e) {
    const error = e as AxiosError;
    return error;
  }
}
  