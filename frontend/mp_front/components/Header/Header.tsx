import styles from "./Header.module.css";

import Navigation from "../Navigation/Navigation";

const authItems = [
    {label: "Войти", href: "/signin"},
    {label: "Регистрация", href: "/signup"},
];

const navItems = [
    {label: "Профиль", href: "/profile"},
    {label: "Домой", href: "/"},
];

export default function Header() {
    return (
        <header className={styles.header}>
            <Navigation navLinks={navItems} authLinks={authItems}/>
            {/* <div className={styles.linksContainer}>
                <Link href="/signin" className={`${styles.link} ${styles.text}`}>Войти</Link>
                <Link href="/signup" className={`${styles.link} ${styles.text}`}>Регистрация</Link>
            </div>
            <Link href="profile" className={`${styles.link} ${styles.text}`}>Профиль</Link>
            <Link href="/" className={styles.link}>Домой</Link> */}
        </header>
    )
}
