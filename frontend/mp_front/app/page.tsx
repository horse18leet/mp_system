"use client"
import styles from './page.module.css';
import ProtectedLayout from '@/common/components/ProtectedLayout/ProtectedLayout';
import BarChart from '@/common/components/BarChart/BarChart';
import LinearChart from '@/common/components/LinearChart/LinearChart';
import { useEffect, useState } from 'react';
import { Card, CardContent, CardFooter, CardHeader, CardTitle } from '@/common/components/ui/card';
import { Button } from '@/common/components/ui/button';
import { updateToken } from '@/common/utils/api/auth/auth';
import { 
  chartListOptions,
  barChartTitle,
  linearChartTitle,
  barChartSeriesNames,
} from '@/common/utils/constants/chart-constants';
export default function Home() {
  
  //нужно сделать запрос к серверу за товарами
  
  const [orderTime, setOrderTime] = useState([]);
  const [orderQuantity, setOrderQuantity] = useState([]);
  const barChartData = [5, 5, 6, 3, 7, 8];  
  const linearChartData1 = [1,2,3,4,5,4,1];
  const linearChartData2 = [7,2,2,1,0,8,2];
  updateToken();
  
  return (
    <ProtectedLayout>
      <section className={`${styles.main}`}>
        <div className={`w-full mb-[50px] grid grid-cols-1 justify-items-center mt-[40px]`}>
          <div className=' flex gap-x-[40px] justify-center w-[100%] px-[40px] mb-[40px]'>
            <div className="">
              <BarChart title={barChartTitle} greenData={barChartData} redData={barChartData} seriesNames={barChartSeriesNames} />
            </div>
            <div className="w-[70%] max-w-[700px]">
              <LinearChart title={linearChartTitle} chartData1={linearChartData1} chartData2={linearChartData2} />
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
