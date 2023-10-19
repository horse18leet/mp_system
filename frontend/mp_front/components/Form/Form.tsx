"use client";

import "./Form.css";
import { SubmitHandler, useForm, useFormState } from "react-hook-form";
import { ChangeEvent, useState } from "react";
import { joiResolver } from '@hookform/resolvers/joi';

import schema from "@/schemes/signupSchema";
import { registration } from "@/app/api/signup/route";

type FormValues = {
    firstName: string
    lastName: string
    email: string
    phoneNumber: string
    password: string
}


export default function Form() {
    const [loggedIn, setLoggedIn] = useState(false);
    const DOMAIN_NAME = process.env.NEXT_PUBLIC_DOMAIN_NAME;
    //const TEST_DOMAIN = "https://api.hvny-diplom.students.nomoredomainsicu.ru"

    const { register, handleSubmit, formState: { errors , isValid, isDirty}} = useForm<FormValues>({
        defaultValues: {
            firstName: "",
            lastName: "",
            email: "",
            phoneNumber: "",
            password: "",
        },
        resolver: joiResolver(schema),
        mode: "onChange",
    });

    function onSubmit(data: { firstName: string; lastName?: string; email?: string; phoneNumber?: string; password?: string; }) {
        setLoggedIn(true);
        return fetch(`${DOMAIN_NAME}/auth/signup`, {
            credentials: "include",
            method: 'POST',
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                firstName: data.firstName,
                email: data.email,
                password: data.password,
                roleType: "USER",
            })
        })
        .catch(err => console.log(err));
    }


    return (
        <form onSubmit={handleSubmit(async (data) => await onSubmit(data))} className="auth-form" noValidate>
            <div className="auth-form__input-container">
                <label htmlFor="name" className="auth-form__label">Имя</label>
                <input 
                    {...register("firstName")}
                    type="text" 
                    // value=""
                    autoComplete="on"
                    id="name"
                    className="auth-form__input"
                >
                </input>
                <span className="auth-form__input__error">{errors.firstName?.message}</span>
            </div>

            <div className="auth-form__input-container">
                <label htmlFor="surname" className="auth-form__label">Фамилия</label>
                <input 
                    {...register("lastName")}
                    type="text" 
                    // value=""
                    autoComplete="on"
                    id="surname"
                    className="auth-form__input"
                >
                </input>
                <span className="auth-form__input__error">{errors.lastName?.message}</span>
            </div>

            <div className="auth-form__input-container">
                <label htmlFor="email" className="auth-form__label">E-mail</label>
                <input 
                    {...register("email")}
                    type="email" 
                    // value=""
                    autoComplete="on"
                    id="email"
                    className="auth-form__input"
                >
                </input>
                <span className="auth-form__input__error">{errors.email?.message}</span>
            </div>

            <div className="auth-form__input-container">
                <label htmlFor="phoneNumber" className="auth-form__label">Номер телефона</label>
                <input 
                    {...register("phoneNumber")}
                    type="tel" 
                    // value=""
                    autoComplete="on"
                    id="phoneNumber"
                    className="auth-form__input"
                >
                </input>
                <span className="auth-form__input__error">{errors.phoneNumber?.message}</span>
            </div>

            <div className="auth-form__input-container">
                <label htmlFor="password" className="auth-form__label">Пароль</label>
                <input 
                   {...register("password")}
                    type="password" 
                    // value=""
                    id="password"
                    autoComplete="on"
                    className="auth-form__input"
                >
                </input>
                <span className="auth-form__input__error">{errors.password?.message}</span>
            </div>

            <button disabled={!isValid || !isDirty} type="submit" className="button auth-form__button auth-form__button_submit">Зарегистрироваться</button>
        </form>
    );
}