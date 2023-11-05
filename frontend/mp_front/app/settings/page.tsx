
import router from "next/router";
import { useEffect } from "react";
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";

import { Button } from "@/components/ui/button";

export default async function Settings() {
      
  return (
    <ProtectedLayout>
      <section>
        <h1>Настройки</h1>
      </section>

      <Button>КНОПКА С КИТА</Button>
    </ProtectedLayout>
  );
}