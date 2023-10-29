"use client";
import Link from "next/link";
import "./page.css";
import styles from '../page.module.css'
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
import ProductsTable from "@/components/ProductsTable/ProductsTable";
import { getItems } from "@/utils/utils";
import { useEffect, useState } from "react";

export default function Items() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        getAllProducts();
    }, [products]);

    async function getAllProducts() {       //получение всех товаров
        const result = await getItems();
        if (result.error) {
            alert(result.error)
        } else {
            setProducts(result.items);
        }
    }

    return (
        <ProtectedLayout>
            <section className={styles.main}>
                <h1>Мои товары</h1>
                {products.length > 0 ? (
                    <ProductsTable />
                ) : 
                (
                    <>
                        <h2>У вас нет товаров</h2>
                        <Link href="/items/new">Создать товар</Link>
                    </>
                )}
            </section>
        </ProtectedLayout>
        
    );
}