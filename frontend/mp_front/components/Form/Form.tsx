"use client";

import styles from "./Form.module.css";
import { SubmitHandler, useForm } from "react-hook-form";
import { useState } from "react";
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


export default function SignupForm() {
    const [loggedIn, setLoggedIn] = useState();
    const DOMAIN_NAME = process.env.NEXT_PUBLIC_DOMAIN_NAME;

    const { register, handleSubmit, formState: { errors , isValid}} = useForm<FormValues>({
        // defaultValues: {
        //     firstName: "",
        //     lastName: "",
        //     email: "",
        //     phoneNumber: "",
        //     password: "",
        // },
        resolver: joiResolver(schema),
    });

    async function onSubmit(data: Object) {
        try {
            const response = await fetch(`${DOMAIN_NAME}/auth/signup`, {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify({ data }),
            });
            const { message } = await response.json();
            alert(message);
          } catch (error) {
            console.error(error);
          }
    }


    return (
        <form onSubmit={handleSubmit(async (data) => await onSubmit(data))} className={styles.form} noValidate>
            <div className={styles.formInputContainer}>
                <label htmlFor="name" className={styles.formLabel}>Имя</label>
                <input 
                    {...register("firstName")}
                    type="text" 
                    // value=""
                    autoComplete="on"
                    id="name"
                    className={styles.formInput}
                >
                </input>
                <span className={`${styles.formInputError}`}>{errors.firstName?.message}</span>
            </div>

            <div className={styles.formInputContainer}>
                <label htmlFor="surname" className={styles.formLabel}>Фамилия</label>
                <input 
                    {...register("lastName")}
                    type="text" 
                    // value=""
                    autoComplete="on"
                    id="surname"
                    className={styles.formInput}
                >
                </input>
                <span className={`${styles.formInputError}`}>{errors.lastName?.message}</span>
            </div>

            <div className={styles.formInputContainer}>
                <label htmlFor="email" className={styles.formLabel}>E-mail</label>
                <input 
                    {...register("email")}
                    type="email" 
                    // value=""
                    autoComplete="on"
                    id="email"
                    className={styles.formInput}
                >
                </input>
                <span className={`${styles.formInputError}`}>{errors.email?.message}</span>
            </div>

            <div className={styles.formInputContainer}>
                <label htmlFor="phoneNumber" className={styles.formLabel}>Номер телефона</label>
                <input 
                    {...register("phoneNumber")}
                    type="tel" 
                    // value=""
                    autoComplete="on"
                    id="phoneNumber"
                    className={styles.formInput}
                >
                </input>
                <span className={`${styles.formInputError}`}>{errors.phoneNumber?.message}</span>
            </div>

            <div className={styles.formInputContainer}>
                <label htmlFor="password" className={styles.formLabel}>Пароль</label>
                <input 
                   {...register("password")}
                    type="password" 
                    // value=""
                    id="password"
                    autoComplete="on"
                    className={styles.formInput}
                >
                </input>
                <span className={`${styles.formInputError}`}>{errors.password?.message}</span>
            </div>

            <button type="submit">Зарегистрироваться</button>
        </form>
    );
}