"use client";

import "./Navigation.css";
import Link from "next/link";
import { usePathname } from "next/navigation";
import DropdownList from "../DropdownMenu/DropdownList";

interface NavLink {
    label: string;
    href: string;
};

type Props = {
    navLinks: NavLink[];
    authLinks: NavLink[];
    loggedIn: boolean;
    handleClick: any;
};

export default function Navigation({ navLinks, authLinks, loggedIn, handleClick }: Props) {
    const pathname = usePathname();
    
    return (
        <div className="links">    
            {loggedIn && <DropdownList/>}
            {!loggedIn ? (
                authLinks.map((link) => {                          //здесь у нас линки на регистрацию и аутентификацию
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
            ) : (
                <>
                {navLinks.map((link) => {                           //здесь линки на всё остальное
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
                })}
                <Link href="/signin" onClick={handleClick} className="link links__link links__text links__link_signout">Выйти</Link>
                </>
            )}
        </div>
    );
}