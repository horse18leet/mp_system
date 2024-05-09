import { mainApi } from "./MainApi";
//import { createTable, saveDataToTable } from "./indexedDB";
import {register, authorize} from './api/auth/auth';
import { AxiosError } from 'axios';
import IRegUserRequest from "./models/user/reg-user-request";

export async function registration(data: IRegUserRequest) {   //регистрация
    const res = await register(data);
    if (res instanceof AxiosError) {
        return { error: res.response?.data.message };
    } else {
        await login(data.email, data.password);
        return { user: res };
    }
}

export async function login(email: string, password: string) {              //вход
    const res = await authorize({email, password});
    if (res instanceof AxiosError) {
        return { res };
    }
    else {
        localStorage.setItem("token", res.access_token);
        localStorage.setItem("refresh_token", res.refresh_token);
        return { token: res.access_token };
    }
}

export async function getItemCategories() {                //получение категорий
    const response = await mainApi.getCategories();
    if (response.message) {
        return { error: response.message };

    } else {
        return { categories: response };
    }
}

export function mergeObjects(obj1: any, obj2: any) {
    for (let key in obj2) {
        if (obj2.hasOwnProperty(key) && !obj1.hasOwnProperty(key)) {
            obj1[key] = obj2[key];
        }
    }
    return obj1;
}

export function formatDate(date: Date, isForReq: boolean) {                                 //преобразование строки в формат даты ДД.ММ.ГГГГ
    const day = String(date.getDate()).padStart(2, '0');                 
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();

    if (isForReq) {
        return `${year}-${month}-${day}T00:00:00`; 
    }
    else {
        return `${day}.${month}.${year}`; 
    }        
}