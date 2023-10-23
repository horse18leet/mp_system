"use client";

import "./Navigation.css";
import Link from "next/link";
import { useSession } from "next-auth/react";
import { usePathname } from "next/navigation";
import DropdownList from "../DropdownMenu/DropdownList";

interface NavLink {
    label: string;
    href: string;
};

type Props = {
    navLinks: NavLink[];
    authLinks: NavLink[];
};

export default function Navigation({ navLinks, authLinks }: Props) {
    const pathname = usePathname();
    const session = useSession();
    //console.log(session);

    return (
        <div className="auth-links">    
            {session?.status === "authenticated" && <DropdownList/>}
            {session?.status !== "authenticated" ? (
                authLinks.map((link) => {                          //здесь у нас линки на регистрацию и аутентификацию
                    const isActive = pathname === link.href;
                    return (
                        <Link
                            key={link.label}
                            href={link.href}
                            className={`auth-links__link link auth-links__text ${isActive ? "auth-links__link_active" : ""}`}
                        >
                        {link.label}
                        </Link>
                    );
                })
            ) : (
                (navLinks.map((link) => {                           //здесь линки на всё остальное
                    const isActive = pathname === link.href;
                    return (
                        <Link
                            key={link.label}
                            href={link.href}
                            className={`auth-links__link link auth-links__text ${isActive ? "auth-links__link_active" : ""}`}
                        >
                        {link.label}
                        </Link>
                    );
                })
            )
            )}
        </div>
    );
}