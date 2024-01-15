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
  const gridParams = "grid grid-cols-2 grid-flow-row gap-[16px] justify-items-center";
  
  return (
    <ProtectedLayout>
      <section className={`${styles.main}`}>
        <h1 className={`mt-[20px] mb-[30px] text-xl`}>Домашняя страница</h1>
        <div className={`w-full mb-[50px] grid grid-cols-1 justify-items-center`}>
          {/* <div className="w-[500px] border-gray-800 border-2 rounded-lg">
            <BarChart 
              data={chartData} 
              labels={chartLabels} 
              title="Мои товары" 
            />
          </div> */}
          <div className=' flex gap-x-[40px] justify-center w-[100%] px-[40px] mb-[40px]'>
            <div className="">
              <BarChart2 title="test" greenData={barChartData} redData={barChartData} />
            </div>
            <div className="w-[70%]">
              <LinearChart title="test" chartData1={linearChartData1} chartData2={linearChartData2} />
            </div>
          </div>
          <div className='flex gap-x-[40px] justify-center w-[100%] px-[40px]'>
            <div className="">
              <Card className='w-[350px]'>
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
              <Card className='w-[350px]'>
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
              <Card className='w-[350px]'>
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
