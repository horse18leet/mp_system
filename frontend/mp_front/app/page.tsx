"use client"
import styles from './page.module.css';
import ProtectedLayout from '@/components/ProtectedLayout/ProtectedLayout';
import BarChart from '@/components/BarChart/BarChart';

export default function Home() {

  const chartData = [5, 5, 6, 3, 7, 8, 2, 2, 2, 3, 4];       //это значения по оси y
  const chartLabels = ["Labeldwdwdw", "LDLDKFDKDK", "Label", "Label", "Label", "Label", "Label", "Label", "Label","Label"]; //это по оси x

  return (
    <ProtectedLayout>
      <section className={styles.main}>
        <h1 className="mt-[20px] mb-[30px] text-xl">Домашняя страница</h1>
        <div className="w-full">
          <div className="w-[500px] border-gray-800 border-2 rounded-lg">
            <BarChart 
              data={chartData} 
              labels={chartLabels} 
              title="Мои товары" 
            />
          </div>
        </div>
      </section>
    </ProtectedLayout>
  )
}
