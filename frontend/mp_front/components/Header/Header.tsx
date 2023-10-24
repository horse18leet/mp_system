"use client";

import "./Header.css";

import Navigation from "../Navigation/Navigation";
import { useState, useEffect } from "react";
import Link from "next/link";
import Image from "next/image";

const authItems = [
    {label: "Войти", href: "/signin"},
    {label: "Регистрация", href: "/signup"},
];

const navItems = [
    {label: "Финансы", href: "/finance"},
    {label: "Планирование", href: "/planning"},
    {label: "Прогнозирование", href: "/prediction"},
    {label: "Настройки", href: "/settings"},
];

export default function Header() {
    //const token = localStorage.getItem("token");
    const [loggedIn, setLoggedIn] = useState(true);
    
    useEffect(()=>{
        const token = localStorage.getItem("token");
        if (token) {
            setLoggedIn(true);
            console.log("true: ", token);
        }
        else {
            setLoggedIn(false);
            console.log(false);

        }
    }, []);

    function handleExit() {
        setLoggedIn(false);
    }
    
    return (
        <header className={`header ${!loggedIn ? "header_not-logged-in" : ""}`}>
            <Link className="link" href="/"><Image src=""  alt="логотип" className="header__logo" /></Link>
            <Navigation navLinks={navItems} authLinks={authItems} loggedIn={loggedIn} handleClick={handleExit}/>
        </header>
    )
}
