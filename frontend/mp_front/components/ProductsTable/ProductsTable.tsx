"use client";

import "./ProductsTable.css"

export default function ProductsTable() {
    return (
        <table className="products-table">
            <thead>
                <tr>
                    <th className="products-table__title">Артикул товара</th>
                    <th className="products-table__title">Наименование</th>
                    <th className="products-table__title">Стоимость</th>
                    <th className="products-table__title">Остаток</th>
                    <th className="products-table__title">Действие</th>
                </tr>
            </thead>
        </table>
    );
}