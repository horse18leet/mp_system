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
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Label } from "@/components/ui/label";
import { Input } from "@/components/ui/input";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { useForm } from "react-hook-form";
import { joiResolver } from "@hookform/resolvers/joi";

import {
  TAccountChangeSchema,
  schema,
} from "@/utils/schemas/account/account-change-data.schema";
import {
  NavigationMenu,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
  NavigationMenuTrigger,
  navigationMenuTriggerStyle,
} from "@/components/ui/navigation-menu";
import Link from "next/link";
import { cn } from "@/lib/utils";
import { SidebarNav } from "@/components/SidebarNav/sidebar-nav";
import { accountSidebarNav } from "@/utils/other-data/account-settings.data";
import { Separator } from "@/components/ui/separator";
import SettingsLayout from "./settings-layout";

export default function Settings() {
  const { setTheme } = useTheme();

  const form = useForm<TAccountChangeSchema>({
    resolver: joiResolver(schema),
    defaultValues: {
      // Когда Никита добавит, сюда будут выгружаться уже существующие значения
      firstName: "",
      lastName: "",
      email: "",
    },
  });

  function onSubmit(data: TAccountChangeSchema) {
    // ...
  }

  return (
    <ProtectedLayout>
      <SettingsLayout title="Аккаунт" description="">
        <Form {...form}>
          <form
            onSubmit={form.handleSubmit(onSubmit)}
            className="space-y-8"
          >
            <FormField
              control={form.control}
              name="firstName"
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Имя</FormLabel>
                  <FormControl>
                    <Input readOnly {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />
            <FormField
              control={form.control}
              name="lastName"
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Фамилия</FormLabel>
                  <FormControl>
                    <Input readOnly {...field} />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />
            <FormField
              control={form.control}
              name="email"
              render={({ field }) => (
                <FormItem>
                  <FormLabel>Email</FormLabel>
                  <FormControl>
                    <Input
                      placeholder="Введите адрес электронной почты..."
                      {...field}
                    />
                  </FormControl>
                  <FormMessage />
                </FormItem>
              )}
            />
          </form>
        </Form>
      </SettingsLayout>

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
    </ProtectedLayout>
  );
}
