"use client";

import styles from '../page.module.css'
import Input from '@/common/components/Input/Input';
import Form from '@/common/components/Form/Form';
import { joiResolver } from '@hookform/resolvers/joi';
import { useForm } from 'react-hook-form';
import { useRouter } from 'next/navigation';
import { login } from "@/common/utils/utils";
import Header from '@/common/components/Header/Header';
import { useState } from 'react';
import loginUserScheme from '@/common/utils/schemas/user/login-user.scheme';

import { useToast } from "@/common/components/ui/use-toast";

export default function Signin() {
    const router = useRouter();
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(loginUserScheme),
        mode: "onChange",
    });

    const [isError, setIsError] = useState(false);
    const [errorData, setErrorData] = useState({errName: ""});
    const { toast } = useToast();

    async function onSubmit(data: { signinEmail: string, signinPassword: string }) {
        const result = await login(data.signinEmail, data.signinPassword);

        if (result.res) {
            toast({
                variant: "destructive",
                title: "Ошибка при авторизации",
                description: result.res.message,
            });
        }
        else {
            router.push("/");
        }
    };

    return (
        <>
        <Header/>
        <section className={styles.main}>
            <h1 className={styles.title}>Вход</h1>
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
                    autoComplete="username"
                    label="E-mail"
                    placeholder="Введите электронную почту"
                    error={errors.signinEmail?.message as any}
                    autoFocus
                />
                <Input
                    name="signinPassword"
                    type="password"
                    autoComplete="current-password"
                    label="Пароль"
                    placeholder="Введите пароль"
                    error={errors.signinPassword?.message as any}
                />
            </Form>
        </section>
        </>
    )
}