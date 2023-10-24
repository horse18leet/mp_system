"use client";

import styles from '../page.module.css'
import schema from "@/schemes/signinSchema";
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import { login } from '@/utils/utils';
import { joiResolver } from '@hookform/resolvers/joi';
import { redirect } from 'next/navigation';
import { useForm } from 'react-hook-form';
import { useRouter } from 'next/navigation';

export default function Signin() {
    const router = useRouter();
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });

    function onSubmit(data: { signinEmail: string, signinPassword: string }) {
        try {
            login(data.signinEmail, data.signinPassword);
            router.push('/');
        } catch(err) {
            console.log("возникла ошибка при отправке формы: ", err);
        }
    }

    return (
        <section className={styles.main}>
            <h1>Вход</h1>
            <Form
                buttonLabel="Войти"
                register={register}
                handleSubmit={handleSubmit}
                onSubmit={onSubmit}
                isValid={isValid}
                isDirty={isDirty}
            >
                <Input
                    name="signinEmail"
                    type="email"
                    label="E-mail"
                    placeholder="Введите электронную почту"
                    error={errors.signinEmail?.message as any}
                    autoFocus
                />
                <Input
                    name="signinPassword"
                    type="password"
                    label="Пароль"
                    placeholder="Введите пароль"
                    error={errors.signinPassword?.message as any}
                />
            </Form>
        </section>
    )
}