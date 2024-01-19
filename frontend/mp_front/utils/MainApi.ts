import Cookies from "js-cookie";
import IItemResponse from "./models/item";

class MainApi {
    private _baseUrl: any;
    constructor(options: any) {
        this._baseUrl = options.baseUrl;
    }

    createItem(name: string, price: string, category: string, link?: string) {  //создание товара
        return fetch(`${this._baseUrl}/item/create`, {
            credentials: "include",
            method: 'POST',
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${Cookies.get("token")}`,
            },
            body: JSON.stringify({
                title: name,
                firstPrice: price,
                category: category,
                mpLink: link,
            })
        })
        .then((res)=> {return res.json()})
    }

    getCategories() {                                   //получаем массив категорий товаров
        return fetch(`${this._baseUrl}/item/category`, {
            credentials: "include",
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${Cookies.get("token")}`,
            },
        })
        .then((res)=> {return res.json()})
    }

    getItems(): Promise<IItemResponse[]> {              //получаем массив товаров
        return fetch(`${this._baseUrl}/item`, {
            credentials: "include",
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${Cookies.get("token")}`,
            },
        })
        .then((res) => {
            if (!res.ok) {
                throw new Error(res.statusText);
            }
            return res.json();
        })
        .catch((error) => {
            return error;
        });
    }

    deleteItem(itemId: string) {                            //удаление товара
        return fetch(`${this._baseUrl}/item/drop`, {
            credentials: "include",
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${Cookies.get("token")}`,
            },
            body: JSON.stringify({
                id: itemId,
            })
        })
        .then((res)=> {return res});
    }

    getUserInfo() {                                 //получение инфы о пользователе
        return fetch(`${this._baseUrl}/user`, {
            credentials: "include",
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${Cookies.get("token")}`,
            },
        })
        .then((res)=> {return res.json()});
    }

    editUserInfo(firstName: string, lastName: string, email: string, password: string) {    //изменение данных пользователя 
        return fetch(`${this._baseUrl}/user/edit`, {
            credentials: "include",
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${Cookies.get("token")}`,
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                email: email,
                password: password,
            })
        })
        .then((res)=> {return res.json()})
    }

}

export const mainApi = new MainApi({
    baseUrl: process.env.NEXT_PUBLIC_DOMAIN_NAME,
});