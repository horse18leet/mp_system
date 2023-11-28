"use client"

import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
import { SidebarNav } from "@/components/SidebarNav/sidebar-nav";
import { accountSidebarNav } from "@/utils/other-data/account-settings.data";
import SettingsLayout from "../settings-layout";
import { useForm } from "react-hook-form";
import {
  TAccountApiKey,
  schema,
} from "@/utils/schemas/account/account-api-key.schema";
import { joiResolver } from "@hookform/resolvers/joi";
import {
  Form,
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";

export default function Keys() {
  const form = useForm<TAccountApiKey>({
    resolver: joiResolver(schema),
    defaultValues: {
      key: "",
    },
  });

  function onSubmit(data: TAccountApiKey) {
    // ...
  }

  return (
    <ProtectedLayout>
      <SettingsLayout
        title="API Ключи"
        description="Управялйте вашими API ключами"
      >
        <Form {...form}>
          <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
            <FormField
              control={form.control}
              name="key"
              render={({ field }) => (
                <FormItem className="flex flex-col justify-start rounded-lg border p-4">
                  <FormLabel className="text-lg leading-none">Wildberries</FormLabel>
                  <FormDescription>Укажите ваш API ключ, для взаимодействия с платформой</FormDescription>
                  <FormControl>
                    <Input placeholder="Введите ключ" {...field} />
                  </FormControl>
                </FormItem>
              )}
            />
            <Button type="submit">Сохранить изменения</Button>
          </form>
        </Form>
      </SettingsLayout>
    </ProtectedLayout>
  );
}
