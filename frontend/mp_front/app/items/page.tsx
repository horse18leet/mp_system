"use client";
import Link from "next/link";
import "./page.css";
import styles from '../page.module.css'
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
import ProductsTable from "@/components/ProductsTable/ProductsTable";
import { getItems, deleteItem } from "@/utils/utils";
import { useEffect, useState } from "react";

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
                <h1>Мои товары</h1>
                {products.length > 0 ? (
                    <ProductsTable productsArray={products} handleDeleteProduct={handleDeleteProduct} />
                ) : 
                (
                    <h2>У вас нет товаров</h2>
                )}
                <Link href="/items/new" className="products__link link">Добавить товар</Link>
            </section>
        </ProtectedLayout>
        
    );
}