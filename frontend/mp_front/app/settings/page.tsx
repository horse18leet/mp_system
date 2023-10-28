
import router from "next/router";
import { useEffect } from "react";
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";

export default async function Settings() {
      
  return (
    <ProtectedLayout>
      <section>
        <h1>Настройки</h1>
      </section>
    </ProtectedLayout>
  );
}