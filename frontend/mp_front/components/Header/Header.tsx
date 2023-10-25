"use client";

import "./Header.css";

import Navigation from "../Navigation/Navigation";
import { useState, useEffect } from "react";
import { useSession, signOut } from "next-auth/react";
import Link from "next/link";
import Image from "next/image";
import logo from "../../images/logo.jpg";
import gear from "../../images/gearIcon.svg";




const authItems = [
    {label: "Войти", href: "/signin"},
    {label: "Регистрация", href: "/signup"},
];

const navItems = [
    {label: "Финансы", href: "/finance"},
    {label: "Планирование", href: "/planning"},
    {label: "Прогнозирование", href: "/prediction"},
];

const settingsItems = [
    {href: "/settings", img: gear, alt: "Настройки", imgClassName: "links__image_gear"},
    {label: "Выйти", href: "/signin", handleClick: signOut()},
];

export default function Header() {
    //const token = localStorage.getItem("token");
    const session = useSession();
    const [loggedIn, setLoggedIn] = useState(true);
    
    useEffect(()=>{
        const token = localStorage.getItem("token");
        if (token) {
            setLoggedIn(true);
         //   console.log("true: ", token);
        }
        else {
            setLoggedIn(false);
           // console.log(false);

        }
    }, []);

    function handleExit() {
        signOut();
        // setLoggedIn(false);
        // localStorage.clear();
    }
    
    return (
        <header className={`header ${!loggedIn ? "header_not-logged-in" : ""}`}>
            <Link className="link" href="/"><Image src={logo} width={50} height={50}  alt="логотип" className="header__logo" /></Link>
            <Navigation navLinks={navItems} authLinks={authItems} settingsLinks={settingsItems} loggedIn={loggedIn} handleClick={handleExit}/>
        </header>
    )
}
