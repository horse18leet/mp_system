"use client";

import "./DropdownList.css";
import Link from "next/link";

export default function DropdownList() {

    return (
        <div className="products-management">
            <span className="button products-management__button">Управление товарами</span>
            <ul className="products-managements__list">
                <li className="products-management__list-item"><Link href="/items" className="products-management__link link">Товары</Link></li>
                <li className="products-management__list-item"><Link href="/deliveries" className="products-management__link link">Поставки</Link></li>
            </ul>
        </div>
    );
}
