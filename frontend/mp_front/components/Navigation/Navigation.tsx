"use client";

import "./Navigation.css";
import Link from "next/link";
import Image from "next/image";
import { usePathname } from "next/navigation";
import DropdownList from "../DropdownList/DropdownList";
import lightMode from "../../images/lightMode.svg";
import darkMode from "../../images/darkMode.svg";
import { useState, useEffect } from "react";

interface NavLink {
    label?: string;
    href?: any;
    img?: string;
    imgClassName?: string;
    alt?: string;
    handleClick?: any;
};

type Props = {
    navLinks: NavLink[];
    settingsLinks: NavLink[];
    authLinks: NavLink[];
    loggedIn: boolean;
    handleClick: any;
};

export default function Navigation({ navLinks, authLinks, settingsLinks, loggedIn, handleClick}: Props) {
    const pathname = usePathname();
    const [mode, setMode] = useState(lightMode);
    
    // useEffect(()=>{
    //     const token = localStorage.getItem("token");
    //     // console.log("token: ", token);
    // });

    function handleChangeMode() {                                       //типа смена темы
        mode === lightMode ? setMode(darkMode) : setMode(lightMode);
    }
    
    return (
        <div className={`links ${(pathname === "/signin" || pathname === "/signup") ? "links_auth" : ""}`}>    
            {(pathname === "/signin" || pathname === "/signup") ? (
                <div className="links__items">
                    {authLinks.map((link) => {                          //здесь у нас линки на регистрацию и аутентификацию
                        const isActive = pathname === link.href;
                        return (
                            <Link
                                key={link.label}
                                href={link.href}
                                className={`links__link link links__text ${isActive ? "links__link_active" : ""}`}
                            >
                            {link.label}
                            </Link>
                            );
                        })
                    }
                </div>
                
            ) : (
                <>
                <div className="links__items links__nav-items">
                    <DropdownList/>
                    {navLinks.map((link) => {                           //здесь навигационные линки
                        const isActive = pathname === link.href;
                        return (
                            <Link
                                key={link.label}
                                href={link.href}
                                className={`links__link link links__text links__link_nav ${isActive ? "links__link_active" : ""}`}
                            >
                            {link.label}
                            </Link>
                        );
                    })}
                </div>
                <div className="links__items links__settings-items">
                    <button className="link links__button links__link" onClick={handleChangeMode}><Image src={mode} alt="Тема" width={15} height={15} /></button>
                    {  
                    settingsLinks.map((link) => {                           //здесь линки, связанные с настройками и кнопка выхода
                        const isActive = pathname === link.href;
                        return (
                            <Link
                                key={link.label || link.alt}
                                href={link.href}
                                className={`links__link link links__text links__link_nav ${isActive && !link.img ? "links__link_active" : ""} ${link.img ? "links__link_img" : ""}`}
                                onClick={handleClick}
                            >
                            {link.label || <Image src={link.img || ""} alt={link.alt || ""} width={15} height={15} className={link.imgClassName} />}
                            </Link>
                        );
                    })}
                </div>
                </>
            )}
        </div>
    );
}