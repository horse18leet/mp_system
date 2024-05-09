import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

import IContractorRequest from "@/utils/models/contractor/contractor-request";
import IContractorResponse from "@/utils/models/contractor/contractor-response";

export async function createContractor(contractor: IContractorRequest): Promise<AxiosResponse | AxiosError | any> {
    try {
      const response = await api.post(`/contractor/create`, contractor);
      const data = response.data;
  
      return data;
  
    } catch (e) {
      const error = e as AxiosError;
      return error;
    }
}

export async function getContractors(): Promise<IContractorResponse[] | AxiosError | any> {
    try {
      const response = await api.get<IContractorResponse[]>("/contractor");
      const data = response.data;
  
      return data;

    } catch (e) {
      const error = e as AxiosError;
  
      return error;
    }
}

export async function getContractor(id: number): Promise<IContractorResponse | AxiosError | any> {
  try {
    const response = await api.get<IContractorResponse>(`/contractor/${id}`);
    const data = response.data;

    return data;

  } catch (e) {
    const error = e as AxiosError;

    return error;
  }
}

export async function deleteContractor(id: number): Promise<AxiosResponse | AxiosError | any> {
  try {
    const response = await api.delete(`/contractor/drop/${id}`);
    
    return response;

  } catch (e) {
    const error = e as AxiosError;

    return error;
  }
}

export async function editContractor(contractor: IContractorRequest): Promise<AxiosResponse | AxiosError | any> {
  try {
    const response = await api.put(`/contractor/edit`, contractor);
    const data = response.data;

    return data;

  } catch (e) {
    const error = e as AxiosError;
    return error;
  }
}
