import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

export async function getDashboardByInterval(dateFrom: string, dateTo: string): Promise<AxiosError | any> {
    try {
      // const response = await api.get("/user?dateFrom=2024-03-06T00:00:00&dateTo=2024-06-06T00:00:00");
      const response = await api.get(`/user/dashboard?dateFrom=${dateFrom}&dateTo=${dateTo}`);
      const data = response.data;

      return data;

    } catch (e) {
      const error = e as AxiosError;
  
      return error;
    }
}