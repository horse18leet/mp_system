import Joi from "joi";

export interface IApiKey {
  key: string;
  clientId?: string;
}

export const WBApiKeySchema = Joi.object({
  key: Joi.string().required(),
});

export const OzonApiKeySchema = Joi.object({
  clientId: Joi.number().required(),
  key: Joi.string().required(),
});

export const YandexMarketApiKeySchema = Joi.object({
  clientId: Joi.number().required(),
  key: Joi.string().required(),
});
