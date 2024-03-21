"use client";
import { useRouter } from "next/navigation";
import { useState, useEffect } from "react";
import Header from "../Header/Header";

export default function ProtectedLayout({ children }: {children: React.ReactNode}) {
    const [loggedIn, setLoggedIn] = useState(false)  //заменить на false
    const router = useRouter();
    
    useEffect(() => {
        const token = localStorage.getItem("token");
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