"use client";

import "./Header.css";

import Navigation from "../Navigation/Navigation";
import { useState } from "react";
import { useSession } from "next-auth/react";
import DropdownMenu from "../DropdownMenu/DropdownList";

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
    const [loggedIn, setLoggedIn] = useState(true);
    const session = useSession();

    
    function handleExit() {
        setLoggedIn(false);
    }
    
    return (
        <header className="header">
            <img src="" alt="логотип" className="header__logo" />
            <Navigation navLinks={navItems} authLinks={authItems} />
            
            {session?.status === "authenticated" && <button className="auth-links__button" onClick={handleExit}>Выйти</button>}

        </header>
    )
}
