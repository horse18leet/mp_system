"use client"

import styles from '../../page.module.css'
import schema from "@/schemes/createProductSchema";
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';

import { useForm } from 'react-hook-form';
import { joiResolver } from '@hookform/resolvers/joi';

export default function Create() {
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });
    const token = "test";
    const DOMAIN_NAME = process.env.NEXT_PUBLIC_DOMAIN_NAME;

    async function onSubmit(data: { name?: string; price?: string; link?: string; }, token?: any) {
        try {
            const data_1 = await fetch(`${DOMAIN_NAME}/item/category`, {
                credentials: "include",
                method: 'POST',
                headers: {
                    "Accept": "application/json",
                    "Content-Type": "application/json",
                    "Authorization": token,
                },
                body: JSON.stringify({
                    name: data.name,
                    price: data.price,
                    link: data.link,
                })
            });
            console.log("data: ", data_1);
        } catch (err) {
            return console.log("ошибка: ", err);
        }
    }


    return (
        <section className={styles.main}>
            <h2>Создать товар</h2>
            <Form
                buttonLabel="Добавить товар"
                register={register}
                handleSubmit={handleSubmit}
                onSubmit={onSubmit}
                isValid={isValid}
                isDirty={isDirty}
            >
                <Input
                    name="name"
                    type="text"
                    label="Название"
                    placeholder="Введите название"
                    error={errors.name?.message as any}
                />
                <Input
                    name="price"
                    type="text"
                    label="Первчиная стоимость"
                    placeholder="Введите первчиную стоимость"
                    error={errors.price?.message as any}
                />

                <Input
                    name="link"
                    type="url"
                    label="Ссылка (если есть)"
                    placeholder="Введите ссылку"
                    error={errors.link?.message as any}
                />
            </Form>
        </section>
    )
} 