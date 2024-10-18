import { AxiosError, AxiosResponse } from "axios";
import api from "../api";

import IRegUserRequest from "@/common/utils/models/user/reg-user-request";
import IRegUserResponse from "@/common/utils/models/user/reg-user-response";
import ILoginUserRequest from "@/common/utils/models/user/login-user-request";
import ILoginUserResponse from "@/common/utils/models/user/login-user-response";

export async function register(user: IRegUserRequest): Promise<IRegUserResponse[] | AxiosError | any> { 
    try {
        const response = await api.post("/auth/signup", user);
        const data = response.data;
        return data;

    } catch(e) {
        const error = e as AxiosError;
        return error;
    }
}

export async function authorize(user: ILoginUserRequest): Promise<ILoginUserResponse[] | AxiosError | any> { 
    try {
        const response = await api.post("/auth/signin", user);
        const data = response.data;
        
        return data;

    } catch(e) {
        const error = e as AxiosError;
        return error;
    }   
}

export async function updateToken(): Promise<AxiosError | any> { 
    try {
        console.log("updateToken");
        const refreshToken = localStorage.getItem('refresh_token');

        // localStorage.removeItem("token");
        const response = await api.post("/auth/refresh-token",
        {
            "refresh-token": refreshToken
        }); 
        const data = response.data;
        localStorage.setItem("token", data.access_token);
        localStorage.setItem("refresh_token", data.refresh_token);

        return data;
    } catch(e) {
        const error = e as AxiosError;
        return error;
    }
}
