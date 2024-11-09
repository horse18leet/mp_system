"use client";

import { useState } from "react";
import { usePathname } from "next/navigation";
import Link from "next/link";
import { Barcode, LogOut, Settings, Truck, User2, BarChart3, PersonStanding  } from "lucide-react";
import {
  NavigationMenu,
  NavigationMenuContent,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
  NavigationMenuTrigger,
  navigationMenuTriggerStyle,
} from "../ui/navigation-menu";
import { ListItem } from "../NavigationListItem/navigation-list-item";
import { Separator } from "../ui/separator";

import { 
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuLabel,
  DropdownMenuRadioGroup,
  DropdownMenuRadioItem,
  DropdownMenuSeparator,
  DropdownMenuTrigger, 
} from "../ui/dropdown-menu";

import { Button } from "../ui/button";

const authItems = [
  { label: "Войти", href: "/signin" },
  { label: "Регистрация", href: "/signup" },
];

const productsManagementItems: {
  label: string;
  icon: React.ReactNode;
  href: string;
  desc: string;
}[] = [
  {
    label: "Товары",
    icon: <Barcode className="mr-2 h-4 w-4" />,
    href: "/items",
    desc: "Добавляйте, редактируйте и отслеживайте доступные товары, чтобы предоставлять вашим клиентам наилучший выбор.",
  },/*
  {
    label: "Поставки",
    icon: <Truck className="mr-2 h-4 w-4" />,
    href: "/deliveries",
    desc: "Обеспечивайте бесперебойное снабжение вашего ассортимента, гарантируя, что товары всегда доступны для ваших клиентов.",
  },*/
  {
    label: "Подрядчики",
    icon: <PersonStanding className="mr-2 h-4 w-4" />,
    href: "/contractors",
    desc: "Добавляйте подрядчиков.",
  }
];

const analyticsItems: {
  label: string;
  icon: React.ReactNode;
  href: string;
  desc: string;
}[] = [
  {
    label: "Трекер позиций",
    icon: <BarChart3 className="mr-2 h-4 w-4" />,
    href: "/items",
    desc: "some text, text again and more text",
  },
  {
    label: "Прогнозирование",
    icon: <BarChart3 className="mr-2 h-4 w-4" />,
    href: "/prediction",
    desc: "some text, text again and more text",
  },
];

const navItems = [
  { label: "Финансы", href: "/finance" },
  { label: "Планирование", href: "/planning" },
  // { label: "Прогнозирование", href: "/prediction" },
  { label: "Swagger", href: "https://api.ucheter.ru/swagger-ui/index.html" },

];

type Props = {
  loggedIn?: boolean;
  setLoggedIn?: any;
};

export default function Header({ loggedIn, setLoggedIn }: Props) {
  const pathname = usePathname();
  const [position, setPosition] = useState("bottom")

  const [currentLang, setCurrentLang] = useState("RU");

  function changeLang(event: any) {
    setCurrentLang(event.target);
  }

  function handleExit() {
    setLoggedIn(false);
    localStorage.removeItem("token");
    localStorage.removeItem("refresh_token");
  }

  return (
    <header className="sticky top-0 z-50 w-full h-[70px] border-b bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60">
      <div className="container flex h-full  items-center">
        <div className="mr-4 hidden md:flex">
          <Link
            className="mr-6 flex items-center space-x-2"
            href={loggedIn ? "/" : pathname}
          >
            <span className="hidden font-bold sm:inline-block">wb</span>
          </Link>
          {loggedIn ? (
            <NavigationMenu>
              <NavigationMenuList className="flex-row">
                <NavigationMenuItem>
                  <NavigationMenuTrigger className="bg-transparent transition-colors text-muted-foreground hover:text-foreground">
                    Товары и подрядчики
                  </NavigationMenuTrigger>
                  <NavigationMenuContent>
                    <ul className="grid w-[400px] gap-2 p-3 md:w-[500px] md:grid-cols-1 lg:w-[520px] ">
                      {productsManagementItems.map((pm) => (
                        <ListItem
                          key={pm.label}
                          title={pm.label}
                          icon={pm.icon}
                          link={pm.href}
                        >
                          {pm.desc}
                        </ListItem>
                      ))}
                    </ul>
                  </NavigationMenuContent>
                </NavigationMenuItem>
                <NavigationMenuItem>
                  <NavigationMenuTrigger className="bg-transparent transition-colors text-muted-foreground hover:text-foreground">
                    Аналитика
                  </NavigationMenuTrigger>
                  <NavigationMenuContent>
                    <ul className="grid w-[400px] gap-2 p-3 md:w-[500px] md:grid-cols-1 lg:w-[520px] ">
                      {analyticsItems.map((pm) => (
                        <ListItem
                          key={pm.label}
                          title={pm.label}
                          icon={pm.icon}
                          link={pm.href}
                        >
                          {pm.desc}
                        </ListItem>
                      ))}
                    </ul>
                  </NavigationMenuContent>
                </NavigationMenuItem>
                {navItems.map((link) => {
                  const isActive = pathname === link.href;

                  return (
                    <NavigationMenuItem
                      key={link.label}
                      className={`transition-colors hover:text-foreground ${
                        isActive ? "text-foreground" : "text-muted-foreground"
                      }`}
                    >
                      <Link
                        legacyBehavior
                        passHref
                        key={link.label}
                        href={link.href}
                      >
                        <NavigationMenuLink
                          className={`bg-transparent ${navigationMenuTriggerStyle()}`}
                        >
                          {link.label}
                        </NavigationMenuLink>
                      </Link>
                    </NavigationMenuItem>
                  );
                })}
              </NavigationMenuList>
            </NavigationMenu>
          ) : (
            <></>
          )}
        </div>
        <div className="flex flex-1 items-center justify-end space-x-2">
          <nav className="flex items-center">
            {loggedIn ? (
              <NavigationMenu>
                <NavigationMenuList>
                  <NavigationMenuItem>
                    <NavigationMenuTrigger className="bg-transparent transition-colors text-muted-foreground hover:text-foreground">
                      Фамилия И.О.
                    </NavigationMenuTrigger>
                    <NavigationMenuContent>
                      <ul className="grid w-56 gap-0 p-3 md:grid-cols-1">
                        <ListItem
                          title="Профиль"
                          icon={<User2 className="mr-2 h-4 w-4" />}
                          className="p-2"
                          link="/profile"
                        />
                        <ListItem
                          title="Настройки"
                          icon={<Settings className="mr-2 h-4 w-4" />}
                          className="p-2"
                          link="/settings"
                        />
                        <Separator className="my-2" />
                        <ListItem
                          title="Выход"
                          icon={<LogOut className="mr-2 h-4 w-4" />}
                          className="p-2"
                          onClick={handleExit}
                          link="/signin"
                        />
                      </ul>
                    </NavigationMenuContent>
                  </NavigationMenuItem>
                </NavigationMenuList>
              </NavigationMenu>
            ) : (
              <div className="space-x-6">
                {authItems.map((link) => {
                  const isActive = pathname === link.href;

                  return (
                    <Link
                      key={link.label}
                      href={link.href}
                      className={`transition-colors hover:text-foreground text-sm font-medium ${
                        isActive ? "text-foreground" : "text-muted-foreground"
                      }`}
                    >
                      {link.label}
                    </Link>
                  );
                })}
              </div>
            )}
          </nav>
          <DropdownMenu>
            <DropdownMenuTrigger asChild>
              <Button variant="outline">{currentLang}</Button>
            </DropdownMenuTrigger>
            <DropdownMenuContent className="w-56">
              <DropdownMenuLabel>Выберите язык</DropdownMenuLabel>
              <DropdownMenuSeparator />
              <DropdownMenuRadioGroup value={currentLang} onValueChange={setCurrentLang}>
                <DropdownMenuRadioItem value="RU">RU</DropdownMenuRadioItem>
                <DropdownMenuRadioItem value="EN">EN</DropdownMenuRadioItem>
              </DropdownMenuRadioGroup>
            </DropdownMenuContent>
        </DropdownMenu>
        </div>
      </div>
    </header>
  );
}
