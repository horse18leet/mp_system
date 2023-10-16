"use client";

import styles from "./Navigation.module.css";
import Link from "next/link";
import { usePathname } from "next/navigation";

type NavLink = {
    label: string;
    href: string;
};

type Props = {
    navLinks: NavLink[];
    authLinks: NavLink[];
};

export default function Navigation({ navLinks, authLinks }: Props) {
    const pathname = usePathname();

    return (
        <>
            <div className={styles.authLinksContainer}>         
                {authLinks.map((link) => {                          //здесь у нас линки на регистрацию и аутентификацию
                    const isActive = pathname === link.href;
                    return (
                        <Link
                            key={link.label}
                            href={link.href}
                            className={`${styles.link} ${styles.text} ${isActive ? styles.linkActive : ""}`}
                        >
                        {link.label}
                        </Link>
                    );
                })}
            </div>

            {navLinks.map((link) => {                           //здесь линки на профиль и домашнюю страницу
                const isActive = pathname === link.href;
                return (
                    <Link
                        key={link.label}
                        href={link.href}
                        className={`${styles.link} ${styles.text} ${isActive ? styles.linkActive : ""}`}
                    >
                    {link.label}
                    </Link>
                );
            })}
        </>
    );
}