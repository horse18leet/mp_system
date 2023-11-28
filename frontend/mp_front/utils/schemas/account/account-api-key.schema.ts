import Joi from "joi";

export type TAccountApiKey = {
    key: string;
}

export const schema = Joi.object({
    key: Joi.string().required()
})