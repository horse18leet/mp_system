"use client";

import styles from '../page.module.css'
import schema from "@/schemes/authSchema";
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import * as auth from "@/utils/auth";

import { useForm } from 'react-hook-form';
import { joiResolver } from '@hookform/resolvers/joi';

export default function Signup() {
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });
    const DOMAIN_NAME = process.env.NEXT_PUBLIC_DOMAIN_NAME;

    async function onSubmit(data: { firstName: string; lastName?: string; email?: string; phoneNumber?: string; password?: string; }) {
        auth.register(data.firstName, data.email, data.password)
        .then((data) => {
            console.log(`УСПЕХ.\ndata: ${data}`)
        })
        .catch((err)=> console.error());
    }

    return (
        <section className={styles.main}>
            <h1>Добро пожаловать</h1>
            <p>Заполните форму для регистрации</p>
            <Form
                buttonLabel="Зарегистрироваться"
                register={register}
                handleSubmit={handleSubmit}
                onSubmit={onSubmit}
                isValid={isValid}
                isDirty={isDirty}
            >
                <Input
                    name="firstName"
                    type="text"
                    label="Имя"
                    placeholder="Введите имя"
                    error={errors.firstName?.message as any}
                    autoFocus
                />
                <Input
                    name="lastName"
                    type="text"
                    label="Фамилия"
                    placeholder="Введите фамилию"
                    error={errors.lastName?.message as any}
                />
                <Input
                    name="email"
                    type="email"
                    label="E-mail"
                    placeholder="Введите электронную почту"
                    error={errors.email?.message as any}
                />
                <Input
                    name="phoneNumber"
                    type="tel"
                    label="Номер телефона"
                    placeholder="Введите номер телефона"
                    error={errors.phoneNumber?.message as any}
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