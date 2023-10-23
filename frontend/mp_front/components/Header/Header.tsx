"use client";

import "./Header.css";

import Navigation from "../Navigation/Navigation";
import { useState, useEffect } from "react";
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
    //const token = localStorage.getItem("token");
    const [loggedIn, setLoggedIn] = useState(false);
    
    useEffect(()=>{
        const token = localStorage.getItem("token");
        if (token) {
            setLoggedIn(true);
        }
        else {
            setLoggedIn(false);
        }
    }, []);

    function handleExit() {
        setLoggedIn(false);
    }
    
    return (
        <header className="header">
            <img src="" alt="логотип" className="header__logo" />
            <Navigation navLinks={navItems} authLinks={authItems} loggedIn={loggedIn}/>
            
            {loggedIn && <button className="auth-links__button" onClick={handleExit}>Выйти</button>}

        </header>
    )
}
