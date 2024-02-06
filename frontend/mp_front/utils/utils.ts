import Cookies from 'js-cookie';
import { mainApi } from "./MainApi";
//import { createTable, saveDataToTable } from "./indexedDB";
import {register, authorize} from './api/auth/auth';
import { AxiosError } from 'axios';

export async function registration(firstName: string, secondName: string, email: string, password: string) {   //регистрация
    const res = await register({firstName, secondName, email, password});
    if (res instanceof AxiosError) {
        return { error: res.response?.data.message };
    } else {
        await login(email, password);
        return { user: res };
    }
}

export async function login(email: string, password: string) {              //вход
    const res = await authorize({email, password});
    if (res instanceof AxiosError) {
        return { error: res.response?.data.message };
    }
    else {
        Cookies.set("token", res.access_token);
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

export async function getUserInfo() {                //получение инфы о пользователе
    const response = await mainApi.getUserInfo();
    if (!response.email) {
        return { error: response.message };
    } else {
        return response;
    }
}

export async function editUserInfo(firstName: string, lastName: string, email: string, password: string) {   //измененние информации пользователя
    const response = await mainApi.editUserInfo(firstName, lastName, email, password);
    if (response.message) {
        return { success: false, error: response.message };
    } else {
        return { success: true, user: response };
    }
}
