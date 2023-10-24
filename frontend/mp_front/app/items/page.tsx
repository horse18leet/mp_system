import Link from "next/link";
import "./page.css";
import styles from '../page.module.css'

import ProductsTable from "@/components/ProductsTable/ProductsTable";
export default function Items() {
    const isProducts = false;
    return (
        <section className={styles.main}>
            <h1>Мои товары</h1>
            {isProducts ? (
                <ProductsTable />
            ) : 
            (
                <>
                    <h2>У вас нет товаров</h2>
                    <Link href="/items/new">Создать товар</Link>
                </>
            )}
            
        </section>
    );
}