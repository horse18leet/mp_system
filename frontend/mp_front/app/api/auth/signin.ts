import { DOMAIN_NAME } from "@/utils/constnats";
import { checkForError } from "@/utils/utils";

export default async function login(email?: string, password?: string) {
    const response = await fetch(`${DOMAIN_NAME}/auth/signin`, {
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
    if (response.ok) {
        const data = await response.json();
        console.log("response: ", response);
        return { success: true, token: data.access_token };
    } else {
        return { success: false, error: 'Authentication failed' };
    }
};