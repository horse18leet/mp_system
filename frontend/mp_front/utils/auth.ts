const DOMAIN_NAME = process.env.NEXT_PUBLIC_DOMAIN_NAME;

export const register = (firstName?: string, email?: string, password?: string) => {
    return fetch(`${DOMAIN_NAME}/auth/signup`, {
        credentials: "include",
        method: 'POST',
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            firstName: firstName,
            email: email,
            password: password,
            roleType: "USER",
        })
    })
    .then(res => res.json());
};

export const authorize = (email?: string, password?: string) => {
    return fetch(`${DOMAIN_NAME}/auth/signin`, {
        credentials: "include",
        method: "POST",
        headers: {
          "Accept": "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
            email: email,
            password: password
        }),
    })
    .then(res => res.json());
};