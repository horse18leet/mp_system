"use client";

import styles from '../page.module.css'
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import { joiResolver } from '@hookform/resolvers/joi';
import { useForm } from 'react-hook-form';
import { useRouter } from 'next/navigation';
import { registration } from '@/utils/utils';
import Header from '@/components/Header/Header';
<<<<<<< Updated upstream
import { useEffect, useState } from 'react';
import { regUserScheme } from '@/utils/schemas/user/reg-user.scheme';
import IRegUserRequest from '@/utils/models/user/reg-user-request';
=======
import { regUserScheme } from '@/utils/schemas/user/reg-user.scheme';
import IRegUserRequest from '@/utils/models/user/reg-user-request';

import { useToast } from "@/components/ui/use-toast";
>>>>>>> Stashed changes

export default function Signup() {
    const router = useRouter()
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({      //определяем некоторые параметры формы
        resolver: joiResolver(regUserScheme),                                                        //используем joiResolver для валидации полей
        mode: "onChange",                                                                     //onChange для валидации в реальном времени
        defaultValues: {
            firstName: "",
            secondName: "",
            email: "",
            phoneNumber: "+7",
            password: "",
        }
    });
    const { toast } = useToast();

<<<<<<< Updated upstream
    useEffect(() => {
        if (isError) {
            setTimeout(() => {
                setIsError(false);
            }, 3000);
        }
    }, [isError]);

=======
>>>>>>> Stashed changes
    async function onSubmit(data: IRegUserRequest) {  //функция сабмита
        const result = await registration(data);
        if (result.error) {
            console.log(result.error);
            toast({
                variant: "destructive",
                title: "Ошибка при регистрации",
                description: result.error,
            });
        }
        else {
            router.push("/");
        }
    }

    return (
        <>
        <Header/>
        <section className={styles.main}>
            <h1 className={styles.title}>Добро пожаловать</h1>
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
                    autoComplete="username"
                    label="Имя"
                    placeholder="Введите имя"
                    error={errors.firstName?.message as any}
                    autoFocus
                />
                <Input
                    name="secondName"
                    type="text"
                    autoComplete="username"
                    label="Фамилия"
                    placeholder="Введите фамилию"
                    error={errors.secondName?.message as any}
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
                    autoComplete="username"
                    label="Номер телефона"
                    placeholder="Введите номер телефона"
                    error={errors.phoneNumber?.message as any}
                />
                <Input
                    name="password"
                    type="password"
                    autoComplete="new-password"
                    label="Пароль"
                    placeholder="Введите пароль"
                    error={errors.password?.message as any}
                />
            </Form>
        </section>
        </>
    )
}