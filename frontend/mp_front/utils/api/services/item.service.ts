import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

import IItemResponse from "../../models/item";

export async function getItems(): Promise<IItemResponse[] | AxiosError> {
  try {
    const response = await api.get<IItemResponse[]>("/item");
    const data = response.data;

    return data;

    // Неизвестно сильно ли ударит по производительности
    // if (Array.isArray(data) && data.every(item => typeof item === 'object' && item !== null)) {
    //     return data
    // }
  } catch (e) {
    const error = e as AxiosError; // Обработку ошибок добавлю позже

    return error;
  }
}

export async function deleteItem(id: number): Promise<AxiosResponse | AxiosError> {
  try {
    const response = await api.delete(`/item/drop/${id}`);
    
    return response;

  } catch (e) {
    const error = e as AxiosError;

    return error;
  }
}
