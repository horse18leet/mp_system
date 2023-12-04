"use client";

import "./Header.css";

import { useRouter } from "next/navigation";
import { usePathname } from "next/navigation";
import Link from "next/link";
import { Barcode, LogOut, Settings, Truck, User2 } from "lucide-react";
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
  },
  {
    label: "Поставки",
    icon: <Truck className="mr-2 h-4 w-4" />,
    href: "/deliveries",
    desc: "Обеспечивайте бесперебойное снабжение вашего ассортимента, гарантируя, что товары всегда доступны для ваших клиентов.",
  },
];

const navItems = [
  { label: "Финансы", href: "/finance" },
  { label: "Планирование", href: "/planning" },
  { label: "Прогнозирование", href: "/prediction" },
];

type Props = {
  loggedIn?: boolean;
  setLoggedIn?: any;
};

export default function Header({ loggedIn, setLoggedIn }: Props) {
  const router = useRouter();
  const pathname = usePathname();

  function handleExit() {
    setLoggedIn(false);
    localStorage.removeItem("token");
    // router.push("/signin");
  }

  return (
    <header className="sticky top-0 z-50 w-full border-b bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60">
      <div className="container flex h-14 items-center">
        <div className="mr-4 hidden md:flex">
          <Link
            className="mr-6 flex items-center space-x-2"
            href={loggedIn ? "/" : pathname}
          >
            <span className="hidden font-bold sm:inline-block">wb</span>
          </Link>
          {loggedIn ? (
            <NavigationMenu>
              <NavigationMenuList>
                <NavigationMenuItem>
                  <NavigationMenuTrigger className="bg-transparent transition-colors text-muted-foreground hover:text-foreground">
                    Товары и поставки
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
        </div>
      </div>
    </header>
  );
}
