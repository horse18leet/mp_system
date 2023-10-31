"use client"

import styles from '../../page.module.css'
import "../page.css";
import schema from "@/schemes/createProductSchema";
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import ProtectedLayout from '@/components/ProtectedLayout/ProtectedLayout';
import  { createItem, getItemCategories } from '@/utils/utils';

import Link from 'next/link';
import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import { joiResolver } from '@hookform/resolvers/joi';

export default function Create() {
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });
    const [categories, setCategories] = useState([]);

    useEffect(()=> {
        getCategories();
    }, []);

    async function getCategories() {
        const result = await getItemCategories();
        console.log(result);
        if (result.error) {
            alert(result.error)
        } else {
            setCategories(result.items);
        }
    }

    async function onSubmit(data: { productName: string; productPrice: string; productLink?: any; }) {
        const result = await createItem(data.productName, data.productPrice, data.productLink);
        if (result.error) {
            alert(result.error)
        } else {
            alert("Товар добавлен");
        }
    }

    return (
        <ProtectedLayout>
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
                        name="productName"
                        type="text"
                        label="Название"
                        placeholder="Введите название"
                        error={errors.productName?.message as any}
                        autoFocus
                    />
                    <Input
                        name="productPrice"
                        type="text"
                        label="Первичная стоимость"
                        placeholder="Введите первчиную стоимость"
                        error={errors.productPrice?.message as any}
                    />

                    <Input
                        name="productLink"
                        type="text"
                        label="Ссылка (если есть)"
                        placeholder="Введите ссылку"
                        error={errors.productLink?.message as any}
                    />

                    <Input
                        name="productCategory"
                        type="text"
                        label="Категория"
                        placeholder="Выберите категорию или введите свою"
                        list = "categories"
                        error={errors.productCategory?.message as any}
                    />
                    <datalist id="categories">
                        {categories.map((item: any) => {
                            return (
                                <option key={item}>{item}</option>
                            )
                        })}
                    </datalist>
                </Form>
                <Link href="/items" className="products__link link">Назад к товарам</Link>
            </section>
        </ProtectedLayout>
    )
} 