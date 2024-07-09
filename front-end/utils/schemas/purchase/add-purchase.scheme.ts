import Joi from "joi";
import { IPurchaseContractor } from "./purchase-contractor/purchase-contractor.scheme";

export interface IAddPurchase {
    // itemId: number;
    quantity: string;
    contractor: any;
    cost: number;
    deadline: any;
    // contractors: IPurchaseContractor[];
}

export const addPurchaseScheme = Joi.object({
    quantity: Joi.string().min(1).pattern(/^\d+$/).required().messages({
        "string.pattern.base": "Поле может содержать только числа",
        "string.min": `Минимальная длина 1 символ`,
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
    contractor: Joi.string().required().messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
    cost: Joi.string().min(1).pattern(/^\d+$/).required().messages({
        "string.pattern.base": "Поле может содержать только числа",
        "string.min": `Минимальная длина 1 символ`,
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
    deadline: Joi.object().required().messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
})
