"use client";

import "./ProductsTable.css"

type Props = {
    productsArray: any;
}

export default function ProductsTable({productsArray}: Props) {
    
    return (
        
        <div>
            {productsArray.map((item: any) => {                          //здесь у нас линки на регистрацию и аутентификацию
                return (
                    <p key = {item.id}>{item.title}</p>    
                );
                })
            }
        </div>
            
        // <table className="products-table">
            
        //     <thead>
        //         <tr>
        //             <th className="products-table__title">Артикул товара</th>
        //             <th className="products-table__title">Наименование</th>
        //             <th className="products-table__title">Стоимость</th>
        //             <th className="products-table__title">Остаток</th>
        //             <th className="products-table__title">Действие</th>
        //         </tr>
        //     </thead>
        // </table>
    );
}