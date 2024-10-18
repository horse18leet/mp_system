import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

import IItemResponse from "@/common/utils/models/item/item-response";
import IItemRequest from "@/common/utils/models/item/item-request";

import { updateToken } from "../auth/auth";

export async function getItems(): Promise<IItemResponse[] | AxiosError | any> {     //any временно добавил, ибо ошибка была, которая мешала билд собрать
  try {
    const response = await api.get<IItemResponse[]>("/item?isDraft=true");

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

export async function getItem(id: number): Promise<IItemResponse | AxiosError | any> {
  try {
    const response = await api.get<IItemResponse>(`/item/${id}`);
    const data = response.data;

    return data;

  } catch (e) {
    const error = e as AxiosError;

    return error;
  }
}

export async function deleteItem(id: number): Promise<AxiosResponse | AxiosError | any> {
  try {
    const response = await api.delete(`/item/drop/${id}`);
    
    return response;

  } catch (e) {
    const error = e as AxiosError;

    return error;
  }
}

export async function createItem(item: IItemRequest): Promise<AxiosResponse | AxiosError | any> {
  try {
    const response = await api.post(`/item/create`, item);
    const data = response.data;

    return data;

  } catch (e) {
    const error = e as AxiosError;
    return error;
  }
}

export async function editItem(item: IItemRequest): Promise<AxiosResponse | AxiosError | any> {
  try {
    const response = await api.put(`/item/edit`, item);
    const data = response.data;

    return data;

  } catch (e) {
    const error = e as AxiosError;
    return error;
  }
}

