"use client";

import React, { useEffect, useRef, useState } from 'react';
import Cookies from "js-cookie";
import ApexCharts from 'apexcharts';
import { chartListOptionsMap } from '@/constants/chartConstants';
import IUserDashboardResponse from '@/utils/models/user/dashboard/user-dashboard-response';
import { formatNumberWithCommas } from '@/utils/utils';

interface seriesNamesProps {
    positiveName: string;
    negativeName: string;
}
interface BarChartProps {
    title: string;
    greenData: Array<number>;
    redData: Array<number>;
    seriesNames: seriesNamesProps;
    dashboard: IUserDashboardResponse
}

const BarChart: React.FC<BarChartProps> = ({ title, greenData, redData, seriesNames, dashboard }) => {
    const barChartRef = useRef<HTMLDivElement>(null);
    const [selectedOption, setSelectedOption] = useState(localStorage.getItem("barChartOption") || "Последние 6 месяцев");
    const [isListOpen, setIsListOpen] = useState(false);

    useEffect(() => {
        if (barChartRef.current && typeof ApexCharts !== "undefined") {
            barChartRef.current.innerHTML = '';
            const options = {
                series: [
                    {
                        name: seriesNames["positiveName"],
                        color: "#31C48D",
                        data: greenData,
                    },
                    {
                        name: seriesNames["negativeName"],
                        color: "#F05252",
                        data: redData,
                    }
                ],
                chart: {
                    sparkline: {
                        enabled: false,
                    },
                    type: "bar",
                    width: "100%",
                    height: 250,
                    style: {
                        cssClass: "box-border",
                    },
                    toolbar: {
                        show: false,
                    }
                },
                fill: {
                    opacity: 1,
                },
                plotOptions: {
                    bar: {
                        horizontal: true,
                        columnWidth: "100%",
                        borderRadiusApplication: "end",
                        borderRadius: 6,
                        dataLabels: {
                            position: "top",
                        },
                    },
                },
                legend: {
                    show: true,
                    position: "bottom",
                },
                dataLabels: {
                    enabled: false,
                },
                tooltip: {
                    enabled: false,
                },
                xaxis: {
                    labels: {
                        show: true,
                        style: {
                            fontFamily: "Inter, sans-serif",
                            cssClass: 'text-xs font-normal fill-gray-500 dark:fill-gray-400'
                        },
                        // formatter: function (value: any) {
                        //     return "" + value
                        // }
                    },
                    categories: ["Июль", "Авг", "Сент", "Окт", "Нояб", "Дек"],
                    axisTicks: {
                        show: false,
                    },
                    axisBorder: {
                        show: false,
                    },
                },
                yaxis: {
                    labels: {
                        show: true,
                        style: {
                            fontFamily: "Inter, sans-serif",
                            cssClass: 'text-xs font-normal fill-gray-500 dark:fill-gray-400'
                        }
                    }
                },
                grid: {
                    show: true,
                    strokeDashArray: 4,
                    padding: {
                        left: 2,
                        right: 2,
                        top: -20
                    },
                },
            }

            const chart = new ApexCharts(barChartRef.current, options);
            chart.render();
        }

    }, []);

    const handleListClick = () => {
        isListOpen ? setIsListOpen(false) : setIsListOpen(true);
    };

    const handleOptionCLick = (evt: any) => {
        setSelectedOption(evt.target.textContent);
        localStorage.setItem("barChartOption", evt.target.textContent); //добавление выбранной опции в localStorage, чтобы при перезагрузке страницы, опция сохранялась
        setIsListOpen(false);
    };

    return (
        <div className="w-full bg-white rounded-lg shadow dark:bg-gray-800 p-4 md:p-6 relative">
            <div className="flex justify-between border-gray-200 border-b dark:border-gray-700 pb-3">
                <dl>
                    <dt className="text-base font-normal text-gray-500 dark:text-gray-400 pb-1">{title}</dt>
                    
                    <dd className="leading-none text-3xl font-bold text-gray-900 dark:text-white">{dashboard.intervalProfit !== undefined ? dashboard.intervalProfit.toLocaleString('ru-RU') : '0'} р.</dd>
                </dl>
                <div>
                    <span className="bg-green-100 text-green-800 text-xs font-medium inline-flex items-center px-2.5 py-1 rounded-md dark:bg-green-900 dark:text-green-300">
                        <svg className="w-2.5 h-2.5 me-1.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 14">
<<<<<<< Updated upstream
                            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13V1m0 0L1 5m4-4 4 4"/>
=======
                            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13V1m0 0L1 5m4-4 4 4" />
>>>>>>> Stashed changes
                        </svg>
                        Уровень прибыли 0%
                    </span>
                </div>
            </div>

            <div className="grid grid-cols-2 py-3">
                <dl>
                    <dt className="text-base font-normal text-gray-500 dark:text-gray-400 pb-1">Доходы</dt>
                    <dd className="leading-none text-xl font-bold text-green-500 dark:text-green-400">{dashboard.sumIncome !== undefined ? dashboard.sumIncome.toLocaleString('ru-RU') : '0'} р.</dd>
                </dl>
                <dl>
                    <dt className="text-base font-normal text-gray-500 dark:text-gray-400 pb-1">Расходы</dt>
                    <dd className="leading-none text-xl font-bold text-red-600 dark:text-red-500">{dashboard.sumExpense !== undefined ? dashboard.sumExpense.toLocaleString('ru-RU') : '0'} р.</dd>
                </dl>
            </div>

            <div ref={barChartRef} id="bar-chart"></div>
            <div className="grid grid-cols-1 items-center border-gray-200 border-t dark:border-gray-700 justify-between">
                <div className="flex justify-between items-center pt-5">
                    <button
                        id="dropdownDefaultButton"
                        className="text-sm font-medium text-gray-500 dark:text-gray-400 hover:text-gray-900 text-center inline-flex items-center dark:hover:text-white"
                        type="button"
                        onClick={handleListClick}>
                        {selectedOption}
                        <svg className="w-2.5 m-2.5 ms-1.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
<<<<<<< Updated upstream
                            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 1 4 4 4-4"/>
=======
                            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 1 4 4 4-4" />
>>>>>>> Stashed changes
                        </svg>
                    </button>
                    {isListOpen ?
                        <div id="lastDaysdropdownBar" className="z-10 bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700 absolute left-[-10px] bottom-[50px]">
                            <ul className="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefaultButton">
                                {Array.from(chartListOptionsMap.keys()).map((option) => {
                                    return (
                                        <li key={option} onClick={handleOptionCLick}>
                                            <p className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white cursor-default">{option}</p>
                                        </li>
                                    );
                                })}
                            </ul>
                        </div>
                        : <></>
                    }
                </div>
            </div>
        </div>
    );
}

export default BarChart;
