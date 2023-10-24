"use client";

import "./Navigation.css";
import Link from "next/link";
import Image from "next/image";
import { usePathname } from "next/navigation";
import { useSession } from "next-auth/react";
import DropdownList from "../DropdownList/DropdownList";
import lightMode from "../../images/lightMode.svg";
import darkMode from "../../images/darkMode.svg";
import { useState } from "react";

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

export default function Navigation({ navLinks, authLinks, settingsLinks, loggedIn}: Props) {
    const pathname = usePathname();
    const session = useSession();
    const [mode, setMode] = useState(lightMode);
    
    console.log(session);

    function handleChangeMode() {
        mode === lightMode ? setMode(darkMode) : setMode(lightMode);
    }
    
    return (
        <div className={`links ${!session?.data ? "links_auth" : ""}`}>    
            {!session?.data ? (
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
                    {navLinks.map((link) => {                           //здесь линки на всё остальное
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
                    settingsLinks.map((link) => {                           //здесь линки на всё остальное
                        const isActive = pathname === link.href;
                        return (
                            <Link
                                key={link.label}
                                href={link.href}
                                className={`links__link link links__text links__link_nav ${isActive && !link.img ? "links__link_active" : ""} ${link.img ? "links__link_img" : ""}`}
                                onClick={link.handleClick}
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