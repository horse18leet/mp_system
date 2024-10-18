"use client";

import { SidebarNav } from "@/common/components/SidebarNav/sidebar-nav";
import { Separator } from "@/common/components/ui/separator";
import { accountSidebarNav } from "@/common/utils/other-data/account-settings.data";

interface SettingsLayoutProps {
  children: React.ReactNode;
  title: string;
  description: string;
}

export default function SettingsLayout({ title, description, children }: SettingsLayoutProps) {
  return (
    <div className="container pt-8">
      <div className="hidden space-y-6 md:block">
        <div className="space-y-0.5">
          <h2 className="text-2xl font-bold tracking-tight">Настройки</h2>
          <p className="text-muted-foreground">
            Управляйте настройками своей учетной записи.
          </p>
        </div>
        <Separator className="my-6" />
        <div className="flex flex-col space-y-8 lg:flex-row lg:space-x-12 lg:space-y-0">
          <aside className="-mx-4 lg:w-1/5">
            <SidebarNav items={accountSidebarNav} />
          </aside>
          <div className="flex-1 lg:max-w-2xl">
            <div className="space-y-6">
              <div>
                <h3 className="text-lg font-medium">{title}</h3>
                <p className="text-sm text-muted-foreground">
                  {description}
                </p>
              </div>
              <Separator />
              {children}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
