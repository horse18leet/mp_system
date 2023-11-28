"use client";

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
import ApiKeyType from "@/utils/models/api-key/api-key.enum";
import {
  createApiKey,
  getApiKeys,
} from "@/utils/api/services/api-keys.service";
import { AxiosError } from "axios";
import { useCallback, useEffect, useState } from "react";
import { IApiKeyRequest } from "@/utils/models/api-key/api-key";

export default function Keys() {
  useEffect(() => {
    async function getAllApiKeys() {
      const response = await getApiKeys();

      form.setValue(
        "wbKey",
        response.find((key) => key.type === ApiKeyType.WB)?.key || ""
      );
      form.setValue(
        "ozonKey",
        response.find((key) => key.type === ApiKeyType.OZON)?.key || ""
      );
      form.setValue(
        "ymKey",
        response.find((key) => key.type === ApiKeyType.YM)?.key || ""
      );
    }

    getAllApiKeys();
  }, []);

  const form = useForm<TAccountApiKey>({
    resolver: joiResolver(schema),
  });

  const { watch } = form;
  const currentValues = watch();

  async function onSubmit(data: TAccountApiKey) {
    const keys: IApiKeyRequest[] = [
      { key: data.wbKey, type: ApiKeyType.WB },
      { key: data.ozonKey, type: ApiKeyType.OZON },
      { key: data.ymKey, type: ApiKeyType.YM },
    ];

    /* TODO:
        Исправить || Переделать
        На данном этапе он проходится по всем полям, а должен только по тем, которые заполнит пользователь, либо тем, которые были изменены
        Если они были изменены, также нужно это обработать, получить с сервера информацию например
    */
    for (let i = 0; i < keys.length; i++) {
      const result = await createApiKey(keys[i]); 
    }
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
              name="wbKey"
              render={({ field }) => (
                <FormItem className="flex flex-col justify-start rounded-lg border p-4">
                  <FormLabel className="text-lg leading-none">
                    Wildberries
                  </FormLabel>
                  <FormDescription>
                    Укажите ваш API ключ продавца Wildberries, для
                    взаимодействия с платформой
                  </FormDescription>
                  <FormControl>
                    <Input placeholder="Введите ключ" {...field} />
                  </FormControl>
                </FormItem>
              )}
            />
            <FormField
              control={form.control}
              name="ozonKey"
              render={({ field }) => (
                <FormItem className="flex flex-col justify-start rounded-lg border p-4">
                  <FormLabel className="text-lg leading-none">Ozon</FormLabel>
                  <FormDescription>
                    Укажите ваш API ключ продавца Ozon, для взаимодействия с
                    платформой
                  </FormDescription>
                  <FormControl>
                    <Input placeholder="Введите ключ" {...field} />
                  </FormControl>
                </FormItem>
              )}
            />
            <FormField
              control={form.control}
              name="ymKey"
              render={({ field }) => (
                <FormItem className="flex flex-col justify-start rounded-lg border p-4">
                  <FormLabel className="text-lg leading-none">
                    Yandex Market
                  </FormLabel>
                  <FormDescription>
                    Укажите ваш API ключ продавца Yandex Market, для
                    взаимодействия с платформой
                  </FormDescription>
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
