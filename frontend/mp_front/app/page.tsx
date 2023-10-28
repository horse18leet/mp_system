import styles from './page.module.css'
import ProtectedLayout from '@/components/ProtectedLayout/ProtectedLayout'

export default function Home() {
  return (
    <ProtectedLayout>
      <section className={styles.main}>
        <h1>Домашняя страница</h1>
      </section>
    </ProtectedLayout>
  )
}
