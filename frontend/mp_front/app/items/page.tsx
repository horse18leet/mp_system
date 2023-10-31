"use client";
import Link from "next/link";
import "./page.css";
import styles from '../page.module.css'
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
import ProductsTable from "@/components/ProductsTable/ProductsTable";
import { getItems, deleteItem } from "@/utils/utils";
import { MouseEventHandler, useEffect, useState } from "react";

export default function Items() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        getAllProducts();
    }, []);

    async function getAllProducts() {       //получение всех товаров
        const result = await getItems();
        if (result.error) {
            alert(result.error)
        } else {
            setProducts(result.items);
        }
    }

    async function handleDeleteProduct(event: React.MouseEvent<HTMLElement>, itemId: string) {
        const result = await deleteItem(itemId);
        if (result.error) {
            alert(result.error)
        } else {
            console.log("збсс");
            const row = (event.target as HTMLElement)?.parentNode?.parentNode;
            row?.parentNode?.removeChild(row);
        }
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
                <Link href="/items/new">Создать товар</Link>
            </section>
        </ProtectedLayout>
        
    );
}