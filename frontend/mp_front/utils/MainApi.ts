class MainApi {
    private _baseUrl: any;
    constructor(options: any) {
        this._baseUrl = options.baseUrl;
    }

    /*проверка на ошибку*/
    _checkForError(res: any) {
        if (res.ok) {
            return res.json()
        }
        return Promise.reject(`Ошибка: ${res.status}`);
    }

    createItem(name: string, price: string, link?: string) {
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
                mpLink: link,
            })
        })
        .then((res)=> this._checkForError(res))
    }

    getCategories() {
        return fetch(`${this._baseUrl}/item/category`, {
            credentials: "include",
            method: 'GET',
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`,
            },
        })
        .then((res)=> this._checkForError(res))
    }

    getItems() {
        return fetch(`${this._baseUrl}/item`, {
            credentials: "include",
            method: 'GET',
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`,
            },
        })
        .then((res)=> this._checkForError(res))
    }

}

export const mainApi = new MainApi({
    baseUrl: process.env.NEXT_PUBLIC_DOMAIN_NAME,
});