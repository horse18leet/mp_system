"use client";

import "./Header.css";

import Navigation from "../Navigation/Navigation";
import { useState, useEffect } from "react";
import { useRouter } from 'next/navigation';
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
    {label: "Выйти", href: "/signin"},
];

type Props = {
    loggedIn?: boolean,
    setLoggedIn?: any,
}

export default function Header({loggedIn, setLoggedIn}: Props) {
    // const token = localStorage.getItem("token");
    const router = useRouter();
    const [isloggedIn, setIsLoggedIn] = useState(loggedIn);
    
    useEffect(()=>{
        const token = localStorage.getItem("token");
        if (token) {
            setIsLoggedIn(true);
         //   console.log("true: ", token);
        }
        else {
            setIsLoggedIn(false);
           // console.log(false);

        }
    }, [loggedIn]);

    async function handleExit() {
        await setIsLoggedIn(false);
        localStorage.removeItem("token");
        router.push("/signin");
    }
    
    return (
        <header className={`header ${!loggedIn ? "header_not-logged-in" : ""}`}>
            <Link className="link" href="/"><Image src={logo} width={50} height={50}  alt="логотип" className="header__logo" /></Link>
            <Navigation navLinks={navItems} authLinks={authItems} settingsLinks={settingsItems} loggedIn={loggedIn as boolean} handleClick={handleExit}/>
        </header>
    )
}
