import { mainApi } from "./MainApi";
//import { createTable, saveDataToTable } from "./indexedDB";
import { register, authorize } from './api/auth/auth';
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
    const res = await authorize({ email, password });
    console.log(res)
    if (res instanceof AxiosError) {
        return { res }
    }
    else {
        localStorage.setItem("token", res.access_token);
        localStorage.setItem("refresh_token", res.refresh_token);
<<<<<<< Updated upstream
=======
        localStorage.setItem("userFirstName", res.userDto.firstName);
        localStorage.setItem("userSecondName", res.userDto.secondName);
        localStorage.setItem("userEmail", res.userDto.email)
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    }
    return obj1;
=======
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

export function minusDaysToDate(dateString: string, days: number) {
    const date = new Date(dateString);
    date.setDate(date.getDate() - days);
    const isoString = date.toISOString();
    return isoString.substring(0, 19);
}


export function getCurrentFormattedDate() {
    const currentDate = new Date();
    const isoString = currentDate.toISOString();
    const formattedDate = isoString.substring(0, 19);
    return formattedDate;
}

export function formatNumberWithCommas(number: number) {
    return number.toLocaleString('ru-RU');
>>>>>>> Stashed changes
}