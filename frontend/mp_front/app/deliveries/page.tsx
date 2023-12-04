"use client";
import Link from "next/link";
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

    // useEffect(() => {
    //     getAllProducts();
    // }, []);

    // async function getAllProducts() {                                                               //получение всех товаров
    //     const result = await getItems();
    //     result.error ? alert(result.error) : setProducts(result.items);
    // }

    return (
        <ProtectedLayout>
            <section className={styles.main}>
                <h1 className="mr-auto ml-[0px] mb-[20px] text-2xl">Мои поставки</h1>
                {products.length > 0 ? (
                <>
                    <Link href="/items/new" className="mr-auto ml-[0px] mb-[20px] products__link link">Добавить поставку</Link>
                    <Table className="mb-[50px]">
                        {/* <TableCaption>Мои товары</TableCaption> */}
                        <TableHeader>
                            <TableRow>
                                <TableHead className="text-center w-[100px]">Идентификатор</TableHead>
                                <TableHead className="text-center">Наименование</TableHead>
                                <TableHead className="text-center">Дата создания</TableHead>
                                <TableHead className="text-center w-[200px]">Дата скана</TableHead>
                                <TableHead className="text-center w-[200px]">Дата окончания</TableHead>
                                <TableHead className="text-center w-[200px]">Статус</TableHead>
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
                                        <TableCell className="text-center">test</TableCell>
                                        <TableCell className="text-center">status</TableCell>
                                    </TableRow>
                                );
                            })}
                        </TableBody>
                    </Table>
                </>
                ) :
                    (
                        <>
                            <h2>У вас нет поставок</h2>
                            <Link href="/deliveries/new" className="products__link link">Добавить поставку</Link>
                        </>
                    )}
            </section>
        </ProtectedLayout>
    );
}