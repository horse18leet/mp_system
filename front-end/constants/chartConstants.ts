export const chartListOptionsMap = new Map<string, number>([
    ["Сегодня", 1],
    ["Вчера", 2],
    ["Последние 7 дней", 7],
    ["Последние 30 дней", 30],
    ["Последние 90 дней", 90]
]);
export const barChartTitle = "Прибыль";
export const linearChartTitle = "Заказы за последние 30 дней";
export const barChartSeriesNames = {
    positiveName: "Доходы",
    negativeName: "Расходы",
}