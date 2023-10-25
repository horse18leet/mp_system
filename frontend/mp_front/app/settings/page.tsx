import { authConfig } from "@/configs/auth";
import { getServerSession } from "next-auth";
import { useSession } from "next-auth/react";
import router from "next/router";
import { useEffect } from "react";

export default async function Settings() {
    const session = useSession();

    useEffect(() => {
        if (!session) {
          router.push('/signin');
          console.log("wdwdwdwdwdwdwdassvd");
        }
      }, [session, router]);
      
    return (
        <section>
            <h1>Настройки</h1>
        </section>
    );
}