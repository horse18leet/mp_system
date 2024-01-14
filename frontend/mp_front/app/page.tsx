"use client"
import styles from './page.module.css';
import ProtectedLayout from '@/components/ProtectedLayout/ProtectedLayout';
import BarChart from '@/components/BarChart/BarChart';
import BarChart2 from '@/components/BarChart2/BarChart2';
import LinearChart from '@/components/LinearChart/LinearChart';
import { useEffect, useState } from 'react';
import { Card, CardContent, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';

export default function Home() {
  
  //нужно сделать запрос к серверу за товарами
  
  const [orderTime, setOrderTime] = useState([]);
  const [orderQuantity, setOrderQuantity] = useState([]);
  const barChartData = [5, 5, 6, 3, 7, 8];  
  const linearChartData1 = [1,2,3,4,5,4,1];
  const linearChartData2 = [7,2,2,1,0,8,2];

  return (
    <ProtectedLayout>
      <section className={styles.main}>
        <h1 className="mt-[20px] mb-[30px] text-xl">Домашняя страница</h1>
        <div className="w-full grid grid-cols-2 grid-flow-row gap-[16px] justify-items-center mb-[50px]">
          {/* <div className="w-[500px] border-gray-800 border-2 rounded-lg">
            <BarChart 
              data={chartData} 
              labels={chartLabels} 
              title="Мои товары" 
            />
          </div> */}
          <div className="">
            <BarChart2 title="test" greenData={barChartData} redData={barChartData} />
          </div>
          <div className="">
            <LinearChart title="test" chartData1={linearChartData1} chartData2={linearChartData2} />
          </div>
          <div className="">
            <Card className='w-[300px]'>
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
            <Card className='w-[300px]'>
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
      </section>
    </ProtectedLayout>
  )
}
