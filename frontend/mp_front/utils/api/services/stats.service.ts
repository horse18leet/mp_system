import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

export async function getStatsDateFrom(): Promise<AxiosError | any> {
    try {
      const response = await api.get("/stats/dateFrom");
      const data = response.data;
  
      return data;

    } catch (e) {
      const error = e as AxiosError;
  
      return error;
    }
}