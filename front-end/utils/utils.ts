import Cookies from 'js-cookie';
import * as auth from "@/utils/auth";
import { mainApi } from "./MainApi";


export async function registration(firstName: string, lastName: string, email: string, password: string) {   //регистрация
    const response = await auth.register(firstName, lastName, email, password);
    if (response.message) {
        return { success: false, error: response.message };

    } else {
        await login(email, password);
        return { success: true, user: response };
    }
}

export async function login(email: string, password: string) {              //вход
    const response = await auth.authorize(email, password);
    console.log("response: ", response);
    if (response.message) {
        return { success: false, error: response.message };

    } else {
        //localStorage.setItem("token", response.access_token);       //добавляем токен в хранилище
        Cookies.set("token", response.access_token);
        return { success: true, token: response.access_token };
    }
}

export async function createItem(name: string, price: string, category: string, link?: string) {   //создание товара
    const response = await mainApi.createItem(name, price, category, link);
    if (response.message) {
        return { error: response.message };

    } else {
        return { item: response };
    }
}

export async function getItems() {
    try {
        const response = await mainApi.getItems();

        if (response) {
            return { items: response };
        } else {
            throw new Error('No response from server');
        }

    } catch (error: any) {
        return {error: error.message}
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

export async function deleteItem(itemId: string) {
    const response = await mainApi.deleteItem(String(itemId));

    if (response.status !== 200) {
        return { error: `Ошибка ${response.status}` };

    } else {
        return { res: response };
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

export async function getUserInfo() {                //получение инфы о пользователе
    const response = await mainApi.getUserInfo();
    if (!response.ok) {
        return { error: response };

    } else {
        return { categories: response };
    }
}