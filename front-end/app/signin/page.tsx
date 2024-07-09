"use client";

import styles from '../page.module.css'
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import { joiResolver } from '@hookform/resolvers/joi';
import { useForm } from 'react-hook-form';
import { useRouter } from 'next/navigation';
import { login } from "@/utils/utils";
import Header from '@/components/Header/Header';
<<<<<<< Updated upstream
import { useEffect, useState } from 'react';
import { CustomError } from '@/components/CustomError/CustomError';
import loginUserScheme from '@/utils/schemas/user/login-user.scheme';
=======
import { useState } from 'react';
import loginUserScheme from '@/utils/schemas/user/login-user.scheme';

import { useToast } from "@/components/ui/use-toast";
>>>>>>> Stashed changes

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