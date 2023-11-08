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
        const result = await deleteItem(itemId);                                                    //отправляем запрос на сервер
        result.error ? alert(result.error) : (event.target as HTMLElement)?.closest("tr")?.remove();//удаляем товар из таблицы, если запрос прошёл
    }

    return (
        <ProtectedLayout>
            <section className={styles.main}>
                <h1 className="items__header">Мои товары</h1>
                {products.length > 0 ? (
                    <Table>
                        {/* <TableCaption>Мои товары</TableCaption> */}
                        <TableHeader>
                            <TableRow>
                                <TableHead className="w-[100px]">#</TableHead>
                                <TableHead>Наименование</TableHead>
                                <TableHead>Категория</TableHead>
                                <TableHead>Первичная стоимость</TableHead>
                                <TableHead className="text-right">Действие</TableHead>
                            </TableRow>
                        </TableHeader>
                        <TableBody>
                            {products.map((item: any, counter) => {                          //строки таблички
                                return (
                                    <TableRow key = {counter}>
                                        <TableCell className="font-medium">{counter+1}</TableCell>
                                        <TableCell>{item.title}</TableCell>
                                        <TableCell>{item.category || "Нет категории"}</TableCell>
                                        <TableCell>{`${item.firstPrice}р`}</TableCell>
                                        <TableCell className="text-right"><button className="button" onClick={(event) => handleDeleteProduct(event, item.id)}>&#10006;</button></TableCell>
                                    </TableRow>
                                );
                            })}
                        </TableBody>
                    </Table>
                ) :
                    (
                        <h2>У вас нет товаров</h2>
                    )}
                <Link href="/items/new" className="products__link link">Добавить товар</Link>
            </section>
        </ProtectedLayout>

    );
}