import IItemResponse from "./models/item";

class MainApi {
    private _baseUrl: any;
    constructor(options: any) {
        this._baseUrl = options.baseUrl;
    }

    createItem(name: string, price: string, category: string, link?: string) {
        return fetch(`${this._baseUrl}/item/create`, {
            credentials: "include",
            method: 'POST',
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`,
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

    getCategories() {
        return fetch(`${this._baseUrl}/item/category`, {
            credentials: "include",
            method: 'POST',
            headers: {
                // "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`,
            },
        })
        .then((res)=> {return res.json()})
    }

    getItems(): Promise<IItemResponse[]> {
        return fetch(`${this._baseUrl}/item`, {
            credentials: "include",
            method: 'POST',
            headers: {
                // "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`,
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

    deleteItem(itemId: string) {
        return fetch(`${this._baseUrl}/item/drop`, {
            credentials: "include",
            method: "POST",
            headers: {
                // "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`,
            },
            body: JSON.stringify({
                id: itemId,
            })
        })
        .then((res)=> {return res});
    }

}

export const mainApi = new MainApi({
    baseUrl: process.env.NEXT_PUBLIC_DOMAIN_NAME,
});