"use client";

import "./ProductsTable.css"

type Props = {
    productsArray: any;
}

export default function ProductsTable({productsArray}: Props) {
    console.log("productsArray: ", productsArray);
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
                {productsArray.map((item: any) => {                          //здесь у нас линки на регистрацию и аутентификацию
                    return (
                        <tr key = {item.id}>
                            <td>{item.title}</td>
                            <td>{item.category || "Нет категории"}</td>
                            <td>{`${item.firstPrice}р`}</td>
                            {/* <td>{item.title}</td> */}
                            <td><button>&#10006;</button></td>
                        </tr>
                    );
                    })
                }
            </tbody>
        </table>
    );
}