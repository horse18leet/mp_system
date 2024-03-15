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
import { useEffect, useState } from 'react';
import { CustomError } from '@/components/CustomError/CustomError';

export default function Signin() {
    const router = useRouter();
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });

    const [isError, setIsError] = useState(false);
    const [errorData, setErrorData] = useState({errName: ""});

    useEffect(() => {
        if (isError) {
            setTimeout(() => {
                setIsError(false);
            }, 3000);
        }
    }, [isError]);

    async function onSubmit(data: { signinEmail: string, signinPassword: string }) {
        const result = await login(data.signinEmail, data.signinPassword);
        if (result.error) {
            setIsError(true);
            setErrorData({...errorData,
                errName: result.error
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
            
            {isError ? <CustomError errName={errorData["errName"]}/> : <></>}

        </section>
        </>
    )
}