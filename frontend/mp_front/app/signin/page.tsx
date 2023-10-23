"use client";

import styles from '../page.module.css'
import schema from "@/schemes/signinSchema";
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import * as auth from "@/utils/auth";
import { useForm } from 'react-hook-form';
import { joiResolver } from '@hookform/resolvers/joi';

export default function Signin() {
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });

    function onSubmit(data: { signinEmail?: string, signinPassword?: string }) {
        const token = localStorage.getItem("token")
        auth.authorize(data.signinEmail, data.signinPassword, token)
        .then((res) => {
            if (res.access_token) {
              localStorage.setItem("token", res.access_token);
              console.log("ВОШЁЁЁЁЛ");
            }
        }) 
        .catch((err) => {
            console.log(err);
        })
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