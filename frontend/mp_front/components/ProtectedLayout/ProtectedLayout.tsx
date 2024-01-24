"use client";
import Cookies from "js-cookie";
import { useRouter } from "next/navigation";
import { useState, useEffect } from "react";
import Header from "../Header/Header";

export default function ProtectedLayout({ children }: {children: React.ReactNode}) {
    //const token = Cookies.get("token");
    const [loggedIn, setLoggedIn] = useState(false)
    const router = useRouter();
    
    useEffect(() => {
        const token = Cookies.get("token");
        if (token) {
            setLoggedIn(true);
        }
        else {
             router.push("/signin");
        }
    }, [loggedIn]);

    return (
        <>
            <Header loggedIn={loggedIn} setLoggedIn={setLoggedIn}/>
            <div>
                {loggedIn && children}
            </div>
        </>
    );
}