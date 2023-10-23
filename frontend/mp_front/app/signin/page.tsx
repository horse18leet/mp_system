"use client";

import styles from '../page.module.css'
import schema from "@/schemes/authSchema";
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
    const DOMAIN_NAME = process.env.NEXT_PUBLIC_DOMAIN_NAME;

    async function onSubmit(data: { email?: string, password?: string }) {
        const token = localStorage.getItem("token")
        auth.authorize(data.email, data.password, token)
        .then((res) => {
            if (res.token) {
              localStorage.setItem("token", res.token);
              console.log("ВОШЁЁЁЁЛ");
            }
          }) 
          .catch((err) => {
            console.log(err);
          })
        // try {
        //     const data_1 = await fetch(`${DOMAIN_NAME}/auth/signin`, {
        //         credentials: "include",
        //         method: 'POST',
        //         headers: {
        //             "Accept": "application/json",
        //             "Content-Type": "application/json",
        //         },
        //         body: JSON.stringify({
        //             email: data.email,
        //             password: data.password,
        //         })
        //     });
        //     console.log("data: ", data_1);
        // } catch (err) {
        //     return console.log("ошибка: ", err);
        // }
    }

    return (
        <section className={styles.main}>
            <h1>Вход</h1>
            <Form
                buttonLabel="Войти"
                register={register}
                handleSubmit={handleSubmit}
                onSubmit={onSubmit}
                isValid={true}
                isDirty={true}
            >
                <Input
                    name="email"
                    type="email"
                    label="E-mail"
                    placeholder="Введите электронную почту"
                    error={errors.email?.message as any}
                />
                <Input
                    name="password"
                    type="password"
                    label="Пароль"
                    placeholder="Введите пароль"
                    error={errors.password?.message as any}
                />
            </Form>
        </section>
    )
}