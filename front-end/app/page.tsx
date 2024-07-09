"use client"
import styles from './page.module.css';
import ProtectedLayout from '@/components/ProtectedLayout/ProtectedLayout';
import BarChart from '@/components/BarChart/BarChart';
import LinearChart from '@/components/LinearChart/LinearChart';
import { useEffect, useLayoutEffect, useState } from 'react';
import { Card, CardContent, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { barChartTitle, linearChartTitle, barChartSeriesNames } from '@/constants/chartConstants';
import { getDashboardByInterval } from '@/utils/api/services/stats.service';
import IUserDashboardResponse from '@/utils/models/user/dashboard/user-dashboard-response';
import { minusDaysToDate, formatDate, getCurrentFormattedDate } from '@/utils/utils';


export default function Home() {

  //нужно сделать запрос к серверу за товарами

  // const [orderTime, setOrderTime] = useState([]);
  const [userDashboard, setDashboard] = useState<IUserDashboardResponse>({
    dateFrom: '',
    dateTo: '',
    intervalProfit: 0,
    ordersPerInterval: new Map<string, number>(),
    sumPriceOrder: 0,
    sumIncome: 0,
    sumExpense: 0,
    orders: []
  });

  const [linearChartData1, setLinearChartData1] = useState<number[]>([]);
  const [linearChartData2, setLinearChartData2] = useState<number[]>([]);
  const [chartDates, setDates] = useState<string[]>();
  const [barChartData, setBarChartData] = useState<number[]>([]);

  useLayoutEffect(() => {
    getUserDashboard();
  }, []);

  async function getUserDashboard() {
    const dateTo = getCurrentFormattedDate();
    const dateFrom = minusDaysToDate(dateTo, 30);
    const dashboard = await getDashboardByInterval(dateFrom, dateTo);

    setDashboard(dashboard);

    const valuesArray = Object.keys(dashboard.ordersPerInterval).map(key => dashboard.ordersPerInterval[key]);
    const dates = Object.keys(dashboard.ordersPerInterval);
    const formattedDates = dates.map(date => {
      const [year, month, day] = date.split('-');
      return `${day}/${month}`;
    });

    setDates(formattedDates)
    setLinearChartData1(valuesArray);
  };

  return (
    <ProtectedLayout>
      <section className={`${styles.main}`}>
        <div className={`w-full mb-[50px] grid grid-cols-1 justify-items-center mt-[40px]`}>
          <div className='flex gap-x-[40px] justify-center w-[100%] px-[40px] mb-[40px]'>
            <div className="">
              <BarChart title={barChartTitle} greenData={barChartData} redData={barChartData} seriesNames={barChartSeriesNames} dashboard={userDashboard} />
            </div>
            <div className="w-[70%] max-w-[700px]">
              <LinearChart title={linearChartTitle} chartData1={linearChartData1} chartData2={linearChartData2} dashboard={userDashboard} chartDates={chartDates!} />
            </div>
          </div>
          <div className='flex gap-x-[40px] justify-center w-[100%] px-[40px]'>
            <div className="">
              <Card className='max-w-[350px]'>
                <CardHeader>
                  <CardTitle>Самая эффективная реклама</CardTitle>
                </CardHeader>
                <CardContent>
                  <p className="">В vk.com/top_wb в 2023 году помогла вам заработать больше 20000 руб.</p>
                </CardContent>
                <CardFooter>
                  <Button className="h-min">К учету&#8594;</Button>
                </CardFooter>
              </Card>
            </div>
            <div className="">
              <Card className='max-w-[350px]'>
                <CardHeader>
                  <CardTitle>Самая эффективная реклама</CardTitle>
                </CardHeader>
                <CardContent>
                  <p className="">В vk.com/top_wb в 2023 году помогла вам заработать больше 20000 руб.</p>
                </CardContent>
                <CardFooter>
                  <Button className="h-min">К учету&#8594;</Button>
                </CardFooter>
              </Card>
            </div>
            <div className="">
              <Card className='max-w-[350px]'>
                <CardHeader>
                  <CardTitle>Самая эффективная реклама</CardTitle>
                </CardHeader>
                <CardContent>
                  <p>В vk.com/top_wb в 2023 году помогла вам заработать больше 20000 руб.</p>
                </CardContent>
                <CardFooter>
                  <Button className="h-min">К учету&#8594;</Button>
                </CardFooter>
              </Card>
            </div>
          </div>
        </div>
      </section>
    </ProtectedLayout>
  )
}

