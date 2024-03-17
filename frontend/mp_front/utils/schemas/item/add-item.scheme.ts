import Joi from "joi";

export interface IAddItem {
    id: number;
    title: string;
    description: string;
    firstPrice: number;
    user: string; // в будущем заменить на тип User
    category: string;
    vendorCode: string;
    mpLink: string;
    isDraft: boolean;
    isActive: boolean;
    createdAt: string;
}

export const addItemScheme = Joi.object({
    title: Joi.string().min(3).max(60).required(),
    description: Joi.string().min(3).max(5000),
    category: Joi.string().min(3).max(200),
    firstPrice: Joi.number().positive().required(),
    // salesPrice: Joi.number().positive().required()
})

