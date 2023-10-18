"use client";

import styles from "./Header.module.css";

import Navigation from "../Navigation/Navigation";
import { useState } from "react";

const authItems = [
    {label: "Войти", href: "/signin"},
    {label: "Регистрация", href: "/signup"},
];

const navItems = [
    {label: "Управление товарами", href: "/products-management"},
    {label: "Финансы", href: "/finance"},
    {label: "Планирование", href: "/planning"},
    {label: "Прогнозирование", href: "/prediction"},
    {label: "Настройки", href: "/settings"},

];

export default function Header() {
    const [loggedIn, setLoggedIn] = useState(true);
    
    function handleExit() {
        setLoggedIn(false);
    }
    
    return (
        <header className={styles.header}>
            <img src="" alt="логотип" className={styles.logo} />
            <Navigation navLinks={navItems} authLinks={authItems} loggedIn={loggedIn}/>
            
            {loggedIn === true && <button className="auth-links__button" onClick={handleExit}>Выйти</button>}

        </header>
    )
}
