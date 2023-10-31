"use client";

import styles from '../page.module.css'
import schema from "@/schemes/signinSchema";
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import { joiResolver } from '@hookform/resolvers/joi';
import { useForm } from 'react-hook-form';
import { useRouter } from 'next/navigation';
import { login } from "@/utils/utils";
import Header from '@/components/Header/Header';

export default function Signin() {
    const router = useRouter();
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });

    async function onSubmit(data: { signinEmail: string, signinPassword: string }) {
        const result = await login(data.signinEmail, data.signinPassword);
        result.error ? alert(result.error) : router.push("/");
    };

    return (
        <>
        <Header/>
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
        </>
    )
}