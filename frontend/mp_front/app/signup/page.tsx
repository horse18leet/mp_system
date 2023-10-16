import { Children } from 'react';
import styles from '../page.module.css'

import Form from '@/components/Form/Form';

type NavLink = {
    label: string;
    href: string;

};


export default function Signup() {
    return (
        <section className={styles.main}>
            <h1>Добро пожаловать</h1>
            <p>Заполните форму для регистрации</p>
            <Form></Form>
        </section>
    )
}