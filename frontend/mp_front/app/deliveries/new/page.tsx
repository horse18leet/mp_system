"use client"

import styles from '../../page.module.css'
import schema from "@/schemes/createProductSchema";
import Input from '@/components/Input/Input';
import Form from '@/components/Form/Form';
import ProtectedLayout from '@/components/ProtectedLayout/ProtectedLayout';
import  { createItem, getItemCategories } from '@/utils/utils';

import Link from 'next/link';
import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import { joiResolver } from '@hookform/resolvers/joi';
import { Card, CardContent, CardFooter, } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Checkbox } from '@/components/ui/checkbox';
import Image from 'next/image';
import { Progress } from '@/components/ui/progress';
import { ComboBox } from '@/components/ui/ComboBox';

const cities = [
    {
      value: "Город A",
      label: "Город A",
    },
    {
      value: "Город B",
      label: "Город B",
    },
    {
      value: "Город C",
      label: "Город C",
    },
    {
      value: "Город D",
      label: "Город D",
    },
    {
      value: "Город E",
      label: "Город E",
    },
];

const warehouses = [
    {
      value: "С транзитным складом",
      label: "С транзитным складом",
    },
    {
      value: "Без транзитного склада",
      label: "Без транзитного склада",
    },
];

export default function Create() {
    const { register, handleSubmit, formState: { errors, isValid, isDirty }} = useForm({ 
        resolver: joiResolver(schema),
        mode: "onChange",
    });
    const [categories, setCategories] = useState([]);

    // useEffect(()=> {
    //     getCategories();
    // }, []);

    async function getCategories() {
        const result = await getItemCategories();
        result.error ? alert(result.error) : setCategories(result.categories);
    }

    async function onSubmit(data: { productName: string; productPrice: string; productCategory: string; productLink?: any; }) {
        const result = await createItem(data.productName, data.productPrice, data.productCategory, data.productLink);
        result.error ? alert(result.error) : alert("Товар добавлен");
    }

    return (
        <ProtectedLayout>
            <section className={styles.main}>
                <Progress value={33} className="h-[10px] mt-[40px]" />
                <div className="w-[100%]">
                    <h2 className="text-xl text-white mt-[20px] mb-[20px]">Выберите склад</h2>
                    <ul className="list-none flex gap-[30px]">
                        <li className="flex flex-col">
                            <label>Склад назначения</label>
                            <ComboBox list={cities} notFoundMessage="Город не найден" title="Город" />

                        </li>
                        <li className="flex flex-col">
                            <label>Транзитный склад</label>
                            <ComboBox list={warehouses} notFoundMessage="" title="Склад"/>
                        </li>
                    </ul>
                    <p className="mt-[20px] text-white text-s">Посмотреть адреса складов можно в Разделе «Карта складов»</p>
                </div>
                <div className="w-[100%]">
                    <h2 className="text-xl text-white mt-[20px] mb-[20px]">Выберите тип поставки</h2>
                    <ul className="list-none flex justify-between">
                        <li>
                            <Card className="w-[350px] h-[317px]">
                                <CardContent>
                                    <div className="grid grid-cols-2 grid-rows-2 mt-[24px]">
                                        <div className="flex items-center space-x-3 mb-[20px] w-min">
                                            <Checkbox id="box" />     
                                            <label htmlFor="box" className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70">
                                                Короб
                                            </label>
                                        </div>
                                        <Image src="" alt = "Короб" className="w-[100px] h-[100px] row-span-2"/>
                                        <div className="flex flex-col text-xs font-light w-min">
                                            <label className="w-min">1&nbsp;из&nbsp;1&nbsp;артикулов,</label>
                                            <label className="w-min">1&nbsp;шт</label>
                                        </div>
                                    </div>
                                    <Button className="w-[140px] h-[20px] ">Смотреть товары</Button>
                                </CardContent>
                                <CardFooter className="flex justify-between">
                                    <p className="font-light text-s leading-5"> 
                                        В&nbsp;транспортировочном коробе товар находится
                                        в&nbsp;своей индивидуальной упаковке. Каждый
                                        короб маркируется уникальным&nbsp;ШК короба.
                                        Если общий объем поставки более 1&nbsp;м3, то
                                        короба необходимо разместить на&nbsp;паллете.
                                    </p>
                                </CardFooter>
                            </Card>
                        </li>
                        <li>
                            <Card className="w-[350px] h-[317px] ">
                                <CardContent>
                                    <div className="grid grid-cols-2 grid-rows-2 mt-[24px]">
                                        <div className="flex items-center space-x-3 mb-[20px] w-min">
                                            <Checkbox id="box" />     
                                            <label htmlFor="box" className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70">
                                                Монопаллета
                                            </label>
                                        </div>
                                        <Image src="" alt = "Монопаллета" className="w-[100px] h-[100px] row-span-2"/>
                                        <div className="flex flex-col text-xs font-light w-min">
                                            <label className="w-min">0&nbsp;из&nbsp;0&nbsp;артикулов,</label>
                                            <label className="w-min">0&nbsp;шт</label>
                                        </div>
                                    </div>
                                    <Button className="w-[140px] h-[20px] ">Смотреть товары</Button>
                                </CardContent>
                                <CardFooter className="flex justify-between">
                                    <p className="font-light text-s leading-5"> 
                                        На&nbsp;паллете можно разместить до&nbsp;3-х артикулов.
                                        Артикулы разделяются картоном вертикально.
                                        по&nbsp;узкой стороне.
                                    </p>
                                </CardFooter>
                            </Card>
                        </li>
                        <li>
                            <Card className="w-[350px] h-[317px]">
                                <CardContent>
                                    <div className="grid grid-cols-2 grid-rows-2 mt-[24px]">
                                        <div className="flex items-center space-x-3 mb-[20px] w-min">
                                            <Checkbox id="box" />     
                                            <label htmlFor="box" className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70">
                                                Суперсейф
                                            </label>
                                        </div>
                                        <Image src="" alt = "Суперсейф" className="w-[100px] h-[100px] row-span-2"/>
                                        <div className="flex flex-col text-xs font-light w-min">
                                            <label className="w-min">0&nbsp;из&nbsp;0&nbsp;артикулов,</label>
                                            <label className="w-min">0&nbsp;шт</label>
                                        </div>
                                    </div>
                                    <Button className="w-[140px] h-[20px] ">Смотреть товары</Button>
                                </CardContent>
                                <CardFooter className="flex justify-between">
                                    <p className="font-light text-s leading-5"> 
                                        Для ювелирной продукции и&nbsp;дорогостоящего мелкого товара.
                                    </p>
                                </CardFooter>
                            </Card>
                        </li>
                    </ul>
                </div>
            </section>
        </ProtectedLayout>
    )
} 


/**
 <h2>Добавить поставку</h2>
                <Form
                    buttonLabel="Добавить поставку"
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
                <Link href="/items" className="products__link link">Назад к поставкам</Link>
 */