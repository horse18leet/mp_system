"use client";

import router from "next/router";
import { useEffect } from "react";
import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";

import { Button } from "@/components/ui/button";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from "../../components/ui/dropdown-menu";
import { Moon, Palette, Sun, SunMoon } from "lucide-react";
import { useTheme } from "next-themes";

export default function Settings() {
  const { setTheme } = useTheme();

  return (
    <ProtectedLayout>
      <section>
        <h1>Настройки</h1>
        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <div className="block select-none space-y-1 rounded-md p-2 leading-none no-underline outline-none transition-colors hover:bg-accent hover:text-accent-foreground focus:bg-accent focus:text-accent-foreground">
              <div className="inline-flex items-center text-sm font-medium leading-none">
                <Palette className="mr-2 h-4 w-4" />
                Тема приложения
              </div>
            </div>
          </DropdownMenuTrigger>
          <DropdownMenuContent align="end">
            <DropdownMenuItem
              className="cursor-pointer"
              onClick={() => setTheme("light")}
            >
              <Sun className="mr-2 h-4 w-4" />
              <span>Светлая</span>
            </DropdownMenuItem>
            <DropdownMenuItem
              className="cursor-pointer"
              onClick={() => setTheme("dark")}
            >
              <Moon className="mr-2 h-4 w-4" />
              <span>Темная</span>
            </DropdownMenuItem>
            <DropdownMenuItem
              className="cursor-pointer"
              onClick={() => setTheme("system")}
            >
              <SunMoon className="mr-2 h-4 w-4" />
              <span>Системная</span>
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      </section>
    </ProtectedLayout>
  );
}
