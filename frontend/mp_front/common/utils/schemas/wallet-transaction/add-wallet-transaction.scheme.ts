import Joi from "joi";

export interface IAddWalletTransaction {
    amount: number;
    description: string;
    type: string;
    contractorDto: any;
    itemDto: any;
}

export const addWalletTransactionScheme = Joi.object({
    amount: Joi.string().pattern(/^\d+$/).required().messages({
        "string.pattern.base": "Поле может содержать только числа",
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
    description: Joi.string().min(3).max(5000).required().messages({
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 5000 символов`,
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
    type: Joi.string().min(3).max(200).required().messages({
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 200 символов`,
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
    contractorDto: Joi.string().min(3).max(200).messages({
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 200 символов`,
        // "string.empty": "Поле обязательно к заполнению",
        // "string.required": "Поле обязательно к заполнению",
    }),
    itemDto: Joi.string().min(3).max(200).messages({
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 200 символов`,
        // "string.empty": "Поле обязательно к заполнению",
        // "string.required": "Поле обязательно к заполнению",
    }),
})
