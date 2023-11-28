import ApiKeyType from "./api-key.enum";

interface IApiKey {
  key: string;
  type: ApiKeyType;
}

export interface IApiKeyResponse extends IApiKey {
  id: number;
  createdAt: Date;
}

export interface IApiKeyRequest extends IApiKey {}
