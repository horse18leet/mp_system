"use client";
import Link from "next/link";
import "./page.css";
import styles from '../page.module.css'
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
import ProductsTable from "@/components/ProductsTable/ProductsTable";
import { getItems, deleteItem } from "@/utils/utils";
import { useEffect, useState } from "react";

import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableHead,
    TableHeader,
    TableRow,
} from "@/components/ui/table"


export default function Items() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        getAllProducts();
    }, []);

    async function getAllProducts() {                                                               //получение всех товаров
        const result = await getItems();
        result.error ? alert(result.error) : setProducts(result.items);
    }

    async function handleDeleteProduct(event: React.MouseEvent<HTMLElement>, itemId: string) {      //удаление товара
        const result = await deleteItem(itemId);   
        result.error ? alert(result.error) : getAllProducts();       //удаляем товар из таблицы, если запрос прошёл
    }

    return (
        <ProtectedLayout>
            <section className={styles.main}>
                <h1 className="items__header">Мои товары</h1>
                {products.length > 0 ? (
                <>
                    <Link href="/items/new" className="ml-auto mr-[50px] mb-[20px] products__link link">Добавить товар</Link>
                    <Table className="mb-[50px]">
                        {/* <TableCaption>Мои товары</TableCaption> */}
                        <TableHeader>
                            <TableRow>
                                <TableHead className="text-center w-[100px]">#</TableHead>
                                <TableHead className="text-center">Наименование</TableHead>
                                <TableHead className="text-center">Категория</TableHead>
                                <TableHead className="text-center w-[200px]">Первичная стоимость</TableHead>
                                <TableHead className="text-center w-[200px]">Действие</TableHead>
                            </TableRow>
                        </TableHeader>
                        <TableBody>
                            {products.map((item: any, counter) => {                          //строки таблички
                                return (
                                    <TableRow key = {counter}>
                                        <TableCell className="text-center font-medium">{counter+1}</TableCell>
                                        <TableCell className="text-center">{item.title}</TableCell>
                                        <TableCell className="text-center">{item.category || "Нет категории"}</TableCell>
                                        <TableCell className="text-center">{`${item.firstPrice}р`}</TableCell>
                                        <TableCell className="text-center"><button className="button" onClick={(event) => handleDeleteProduct(event, item.id)}>&#10006;</button></TableCell>
                                    </TableRow>
                                );
                            })}
                        </TableBody>
                    </Table>
                </>
                ) :
                    (
                        <>
                            <h2>У вас нет товаров</h2>
                            <Link href="/items/new" className="products__link link">Добавить товар</Link>
                        </>
                    )}
            </section>
        </ProtectedLayout>
    );
}