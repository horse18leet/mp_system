import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

import IPurchaseRequest from "@/utils/models/purchase/purchase-request";
import IPurchaseResponse from "@/utils/models/purchase/purchase-response";

export async function createPurchase(purchase: IPurchaseRequest): Promise<AxiosResponse | AxiosError> {
  try {
    const response = await api.post(`/purchase/create`, purchase);
    const data = response.data;
  
    return data;
  
  } catch (e) {
    const error = e as AxiosError;
    return error;
  }
}