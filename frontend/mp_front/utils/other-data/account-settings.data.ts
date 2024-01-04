import { KeySquare, ShieldAlert, UserCog } from "lucide-react";

export const accountSidebarNav = [
  {
    title: "Аккаунт",
    icon: UserCog,
    href: "/settings",
  },
  {
    title: "Безопасность",
    icon: ShieldAlert,
    href: "/settings/security",
  },
  {
    title: "API Ключи",
    icon: KeySquare,
    href: "/settings/keys",
  },
];
