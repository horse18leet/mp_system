import { DOMAIN_NAME } from "@/utils/constnats";
import { checkForError } from "@/utils/utils";

export default async function registration(firstName?: string, email?: string, password?: string) {
    const response = await fetch(`${DOMAIN_NAME}/auth/signup`, {
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
    if (response.ok) {
        const data = await response.json();
        console.log("data: ", data);
        return { success: true, user: data };
    } else {
        return { success: false, error: 'Registration failed' };
    }
};