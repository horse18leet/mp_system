import { Children } from 'react';
import styles from '../page.module.css'

import SignupForm from '@/components/Form/Form';

export default function Signup() {
    return (
        <section className={styles.main}>
            <h1>Добро пожаловать</h1>
            <p>Заполните форму для регистрации</p>
            <SignupForm></SignupForm>
        </section>
    )
}