"use client";

import styles from "./Form.module.css";
import { SubmitHandler, useForm } from "react-hook-form";

type Inputs = {
    example: string
    exampleRequired: string
}

interface FormInput {
    name: string
    surname: string;
    email: string;
    phoneNumber: string;
    password: string;
  }

export default function Form() {
    const { register, handleSubmit, formState: { errors }} = useForm<FormInput>()
    const onSubmit: SubmitHandler<FormInput> = (data) => console.log(data)


    return (
        <form name="form" onSubmit={handleSubmit(onSubmit)} className={styles.form}>
            <div className={styles.formInputContainer}>
                <label htmlFor="name" className={styles.formLabel}>Имя</label>
                <input type="text" autoComplete="on" {...register("name")} />
                <input 
                    {...register("name"), {required: true}}
                    type="text" 
                    // value=""
                    autoComplete="on"
                    pattern="^[A-Za-zА-Яа-яЁё\-\s]+$"
                    id="name"
                    className={styles.formInput}
                >
                </input>
                <span className={`${styles.formInputError}`}>err</span>
            </div>
            <div className={styles.formInputContainer}>
                <label htmlFor="surname" className={styles.formLabel}>Фамилия</label>
                <input 
                    type="text" 
                    required
                    // value=""
                    autoComplete="on"
                    pattern="^[A-Za-zА-Яа-яЁё\-\s]+$"
                    id="surname"
                    className={styles.formInput}
                    {...register("surname")}
                >
                </input>
                <span className={`${styles.formInputError}`}>err</span>
            </div>
            <div className={styles.formInputContainer}>
                <label htmlFor="email" className={styles.formLabel}>E-mail</label>
                <input 
                    type="email" 
                    required
                    // value=""
                    autoComplete="on"
                    pattern="[a-zA-Z0-9_.+\-]+@[a-zA-Z0-9\-]+\.[a-z]{2,4}$"
                    id="email"
                    className={styles.formInput}
                    {...register("email")}
                >
                </input>
                <span className={`${styles.formInputError}`}></span>
            </div>
            <div className={styles.formInputContainer}>
                <label htmlFor="phoneNumber" className={styles.formLabel}>Номер телефона</label>
                <input 
                    type="tel" 
                    required
                    // value=""
                    autoComplete="on"
                    pattern="/^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$/"
                    id="phoneNumber"
                    className={styles.formInput}
                    {...register("phoneNumber")}
                >
                </input>
                <span className={`${styles.formInputError}`}></span>
            </div>
            <div className={styles.formInputContainer}>
                <label htmlFor="password" className={styles.formLabel}>Пароль</label>
                <input 
                    type="password" 
                    required
                    // value=""
                    id="password"
                    autoComplete="on"
                    className={styles.formInput}
                    {...register("password")}
                >
                </input>
                <span className={`${styles.formInputError}`}></span>
            </div>
            <button type="submit">Зарегистрироваться</button>
        </form>
    );
}