import * as auth from "@/utils/auth";
import { mainApi } from "./MainApi";

export function registration(firstName: string, email: string, password: string) {
    auth.register(firstName, email, password)
        .then((res) => {
            if (res.ok) {
                login(email, password);
            }
        })
        .catch((err)=> console.error());
}

export function login(email: string, password: string) {
    auth.authorize(email, password)
        .then((res) => {
            if (res.access_token) {
              localStorage.setItem("token", res.access_token);
            }
        }) 
        .catch((err) => console.error())
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