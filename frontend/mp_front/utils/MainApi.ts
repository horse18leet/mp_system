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

    createProduct(name?: string, price?: string, link?: string) {
        return fetch(`${this._baseUrl}/item/create`, {
            credentials: "include",
            method: 'POST',
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("token")}`,
            },
            body: JSON.stringify({
                name: name,
                price: price,
                link: link,
            })
        })
        .then((res)=> this._checkForError(res))
    }
}

export const mainApi = new MainApi({
    baseUrl: process.env.NEXT_PUBLIC_DOMAIN_NAME,
});