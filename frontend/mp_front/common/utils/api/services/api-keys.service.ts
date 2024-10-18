import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

import {
  IApiKeyRequest,
  IApiKeyResponse,
} from "@/common/utils/models/api-key/api-key";

export async function createApiKey(
  apiKey: IApiKeyRequest
): Promise<IApiKeyResponse> {
  const response = await api
    .post<IApiKeyResponse>("/api-key", apiKey)
    .then((response) => response.data)
    .catch((error) => {
      throw error;
    });

  return response;
}

export async function getApiKeys(type?: string): Promise<IApiKeyResponse[]> {
  if (type) {
    const response = await api
      .get<IApiKeyResponse[]>(`/api-key?type=${type}`)
      .then((response) => response.data)
      .catch(error => {
        throw error;
      });

    return response;
  } else {
    const response = await api
      .get<IApiKeyResponse[]>("/api-key")
      .then((response) => response.data)
      .catch((error) => {
        throw error;
      });

    return response;
  }
}
