import * as auth from "@/utils/auth";
import { mainApi } from "./MainApi";

export async function registration(firstName: string, email: string, password: string) {
    const response = await auth.register(firstName, email, password)
    if (response.message) {
        return { success: false, error: response.message };

    } else {
        console.log("response_reg: ", response);
        await login(email, password);
        return { success: true, user: response };
    }
}

export default async function login(email: string, password: string) {
    const response = await auth.authorize(email, password)
    if (response.message) {
        return { success: false, error: response.message };

    } else {
        console.log("response_login: ", response);
        localStorage.setItem("token", response.access_token);       //добавляем токен в хранилище
        return { success: true, token: response.access_token };
    }
}

export function createItem(name: string, price: string, link?: string) {
    mainApi.createProduct(name,price,link)
        .then((data) => {
            console.log(`data: ${data}`)
        })
        .catch((err) => console.error());
}

export const checkForError = (res: any) => {
    if (res.ok) {
        return res.json()
    }
    return Promise.reject(`Ошибка: ${res.status}`);
}