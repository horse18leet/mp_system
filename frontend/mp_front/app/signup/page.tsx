"use client";

import styles from '../page.module.css'
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import { CustomAlert } from '@/components/CustomAlert/CustomAlert';
import { joiResolver } from '@hookform/resolvers/joi';
import { useForm } from 'react-hook-form';
import { useRouter } from 'next/navigation';
import { registration } from '@/utils/utils';
import Header from '@/components/Header/Header';
import { useEffect, useState } from 'react';
import { regUserScheme } from '@/utils/schemas/user/reg-user.scheme';
import IRegUserRequest from '@/utils/models/user/reg-user-request';

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
    const [isError, setIsError] = useState(false);
    const [errorData, setErrorData] = useState({errName: ""});

    useEffect(() => {
        if (isError) {
            setTimeout(() => {
                setIsError(false);
            }, 3000);
        }
    }, [isError]);

    async function onSubmit(data: IRegUserRequest) {  //функция сабмита
        const result = await registration(data);
        if (result.error) {
            setIsError(true);
            setErrorData({...errorData,
                errName: result.error
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

            {isError ? <CustomAlert type="error" title={errorData["errName"]} /> : <></>}
        </section>
        </>
    )
}