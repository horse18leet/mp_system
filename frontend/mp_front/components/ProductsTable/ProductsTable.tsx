"use client";

import "./ProductsTable.css"

type Props = {
    productsArray: Array<string>;
    handleDeleteProduct: any;
}

export default function ProductsTable({productsArray, handleDeleteProduct}: Props) {

    return (
        <table className="products__table">
            <thead className="products__table-headers">
                <tr>
                    <th className="products-table__title">Наименование</th>
                    <th className="products-table__title">Категория</th>
                    <th className="products-table__title">Первичная стоимость</th>
                    {/* <th className="products-table__title">Остаток</th> */}
                    <th className="products-table__title">Действие</th>
                </tr>
            </thead>
            <tbody>
                {productsArray.map((item: any) => {                          //строки таблички
                    return (
                        <tr key = {item.id}>
                            <td>{item.title}</td>
                            <td>{item.category || "Нет категории"}</td>
                            <td>{`${item.firstPrice}р`}</td>
                            {/* <td>{item.title}</td> */}
                            <td><button className="button" onClick={(event) => handleDeleteProduct(event, item.id)}>&#10006;</button></td>
                        </tr>
                    );
                    })
                }
            </tbody>
        </table>
    );
}