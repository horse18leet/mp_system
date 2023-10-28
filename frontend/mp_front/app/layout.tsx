import Header from '@/components/Header/Header'
import './globals.css'
import type { Metadata } from 'next'
import { Inter } from 'next/font/google'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'Mp front',
  description: 'Make it easier to work with business',
}

export default function RootLayout({ children, }: { children: React.ReactNode }) {
  return (
    <html lang="ru">
      <body className={inter.className}>
          {/* <Header/> */}
          <main>
            {children}
          </main>
      </body>
    </html>
  )
}
