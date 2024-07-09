interface IUserDashboardResponse {
    dateFrom: string;
    dateTo: string;
    ordersPerInterval: Map<string, number>
    intervalProfit: number;
    sumPriceOrder: number;
    sumIncome: number;  
    sumExpense: number;
    orders: IOrder[];
}

export default IUserDashboardResponse;