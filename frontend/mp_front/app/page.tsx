"use client"
import styles from './page.module.css';
import ProtectedLayout from '@/components/ProtectedLayout/ProtectedLayout';
import BarChart from '@/components/BarChart/BarChart';

export default function Home() {

  const chartData = [5, 5, 6, 3, 7, 8];       //это размер стобцов в графике
  const chartLabels = ["Label", "another Label", "another Label", "another Label", "another Label", "another Label"]; //это заголовки столбцов

  return (
    <ProtectedLayout>
      <section className={styles.main}>
        <h1 className="mt-[20px] mb-[30px] text-xl">Домашняя страница</h1>
        <div className="w-[500px] border-gray-50 rounded-xl">
          <BarChart 
            data={chartData} 
            labels={chartLabels} 
            title="Мои товары" 
          />
        </div>
      </section>
    </ProtectedLayout>
  )
}
