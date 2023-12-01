"use client";

import ProtectedLayout from "@/components/ProtectedLayout/ProtectedLayout";
import { SidebarNav } from "@/components/SidebarNav/sidebar-nav";
import { accountSidebarNav } from "@/utils/other-data/account-settings.data";
import SettingsLayout from "../settings-layout";
import { useForm } from "react-hook-form";
import {
  WBApiKeySchema,
  OzonApiKeySchema,
  YandexMarketApiKeySchema,
  IApiKey,
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
import { Separator } from "@/components/ui/separator";
import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from "@/components/ui/accordion";

export default function Keys() {
  const WBApiKeyForm = useForm<IApiKey>({
    resolver: joiResolver(WBApiKeySchema),
  });

  const OzonApiKeyForm = useForm<IApiKey>({
    resolver: joiResolver(OzonApiKeySchema),
  });

  const YandexMarketApiKeyForm = useForm<IApiKey>({
    resolver: joiResolver(YandexMarketApiKeySchema),
  });

  async function onSubmitWB(data: IApiKey) {
    const key: IApiKeyRequest = {
      key: data.key,
      type: ApiKeyType.WB,
    };

    const result = await createApiKey(key);
  }

  async function onSubmitOzon(data: IApiKey) {
    const key: IApiKeyRequest = {
      key: data.key,
      clientId: data.clientId,
      type: ApiKeyType.WB,
    };

    const result = await createApiKey(key);
  }

  async function onSubmitYM(data: IApiKey) {
    const key: IApiKeyRequest = {
      key: data.key,
      clientId: data.clientId,
      type: ApiKeyType.WB,
    };

    const result = await createApiKey(key);
  }

  useEffect(() => {
    async function getAllApiKeys() {
      const response = await getApiKeys();

      WBApiKeyForm.setValue(
        "key",
        response.find((key) => key.type === ApiKeyType.WB)?.key || ""
      );
      OzonApiKeyForm.setValue(
        "key",
        response.find((key) => key.type === ApiKeyType.OZON)?.key || ""
      );
      OzonApiKeyForm.setValue(
        "clientId",
        response.find((key) => key.type === ApiKeyType.OZON)?.clientId || ""
      );
      YandexMarketApiKeyForm.setValue(
        "key",
        response.find((key) => key.type === ApiKeyType.YM)?.key || ""
      );
      YandexMarketApiKeyForm.setValue(
        "clientId",
        response.find((key) => key.type === ApiKeyType.YM)?.clientId || ""
      );
    }

    getAllApiKeys();
  }, []);

  return (
    <ProtectedLayout>
      <SettingsLayout
        title="API Ключи"
        description="Управялйте вашими API ключами"
      >
        <Form {...WBApiKeyForm}>
          <form
            onSubmit={WBApiKeyForm.handleSubmit(onSubmitWB)}
            className="space-y-8"
          >
            <div className="flex flex-col space-y-4 rounded-lg border p-4">
              <div className="flex flex-col space-y-2">
                <span className="font-medium peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-lg leading-none">
                  Wildberries
                </span>
                <span className="text-sm text-muted-foreground">
                  Заполните поля, чтобы получить доступ к взаимодействию с
                  платформой
                </span>
              </div>
              <FormField
                control={WBApiKeyForm.control}
                name="key"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>API Ключ</FormLabel>
                    <FormControl>
                      <Input placeholder="Введите ключ..." {...field} />
                    </FormControl>
                  </FormItem>
                )}
              />
            </div>
            <Button type="submit">Сохранить данные</Button>
          </form>
        </Form>
        <div className="pt-6">
          <h3 className="text-lg font-medium">Другие платформы</h3>
          <p className="text-sm text-muted-foreground">
            Расскройте, чтобы заполнить данные о других платформах
          </p>
        </div>
        <Separator />
        <Accordion type="single" collapsible>
          <AccordionItem value="ozon">
            <AccordionTrigger>Ozon</AccordionTrigger>
            <AccordionContent>
              <Form {...OzonApiKeyForm}>
                <form
                  onSubmit={OzonApiKeyForm.handleSubmit(onSubmitOzon)}
                  className="space-y-8"
                >
                  <div className="flex flex-col space-y-4 rounded-lg border p-4">
                    <div className="flex flex-col space-y-2">
                      <span className="font-medium peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-lg leading-none">
                        Ozon
                      </span>
                      <span className="text-sm text-muted-foreground">
                        Заполните поля, чтобы получить доступ к взаимодействию с
                        платформой
                      </span>
                    </div>
                    <FormField
                      control={OzonApiKeyForm.control}
                      name="clientId"
                      render={({ field }) => (
                        <FormItem>
                          <FormLabel>ClientId</FormLabel>
                          <FormControl>
                            <Input
                              placeholder="Введите ClientId..."
                              {...field}
                            />
                          </FormControl>
                        </FormItem>
                      )}
                    />
                    <FormField
                      control={OzonApiKeyForm.control}
                      name="key"
                      render={({ field }) => (
                        <FormItem>
                          <FormLabel>API Ключ</FormLabel>
                          <FormControl>
                            <Input placeholder="Введите ключ..." {...field} />
                          </FormControl>
                        </FormItem>
                      )}
                    />
                  </div>
                  <Button type="submit">Сохранить данные</Button>
                </form>
              </Form>
            </AccordionContent>
          </AccordionItem>
          <AccordionItem value="ym">
            <AccordionTrigger>Yandex Market</AccordionTrigger>
            <AccordionContent>
              <Form {...YandexMarketApiKeyForm}>
                <form
                  onSubmit={YandexMarketApiKeyForm.handleSubmit(onSubmitYM)}
                  className="space-y-8 pb-8"
                >
                  <div className="flex flex-col space-y-4 rounded-lg border p-4">
                    <div className="flex flex-col space-y-2">
                      <span className="font-medium peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-lg leading-none">
                        Yandex Market
                      </span>
                      <span className="text-sm text-muted-foreground">
                        Заполните поля, чтобы получить доступ к взаимодействию с
                        платформой
                      </span>
                    </div>
                    <FormField
                      control={YandexMarketApiKeyForm.control}
                      name="clientId"
                      render={({ field }) => (
                        <FormItem>
                          <FormLabel>ClientId</FormLabel>
                          <FormControl>
                            <Input
                              placeholder="Введите ClientId..."
                              {...field}
                            />
                          </FormControl>
                        </FormItem>
                      )}
                    />
                    <FormField
                      control={YandexMarketApiKeyForm.control}
                      name="key"
                      render={({ field }) => (
                        <FormItem>
                          <FormLabel>API Ключ</FormLabel>
                          <FormControl>
                            <Input placeholder="Введите ключ..." {...field} />
                          </FormControl>
                        </FormItem>
                      )}
                    />
                  </div>
                  <Button type="submit">Сохранить данные</Button>
                </form>
              </Form>
            </AccordionContent>
          </AccordionItem>
        </Accordion>
      </SettingsLayout>
    </ProtectedLayout>
  );
}
