"use client";

import "./DropdownList.css";
import { useState, useEffect, useRef } from 'react';
import Link from "next/link";


export default function DropdownList() {
    const [isOpen, setIsOpen] = useState(false);
    const dropdownRef = useRef<HTMLDivElement>(null);

    useEffect(() => {
        document.addEventListener('click', handleClickOutside);
        return () => {
            document.removeEventListener('click', handleClickOutside);
        };
    }, []);

    function toggleList() {                 //открытие выпадающего списка
        setIsOpen(!isOpen);
    }

    function handleClickOutside(event: MouseEvent) {    //закрытие выпадающего списка при клике на окружающую область
        if (dropdownRef.current && !dropdownRef.current.contains(event.target as Node)) {
          setIsOpen(false);
        }
    };

    return (
        <div className="products-management" ref={dropdownRef}>
            <button onClick={toggleList} className="products-management__button button">Управление товарами</button>
            {isOpen && (
            <ul className="products-managements__list">
                <li className="products-management__list-item"><Link href="/items" className="products-management__link link">Товары</Link></li>
                <li className="products-management__list-item"><Link href="/deliveries" className="products-management__link link">Поставки</Link></li>
            </ul>
            )}
        </div>
    );
}
