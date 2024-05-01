import Joi from "joi";

export interface IAddItem {
    id: number;
    title: string;
    description: string;
    firstPrice: string;
    user: string; // в будущем заменить на тип User
    category: string;
    vendorCode: string;
    mpLink: string;
    isDraft: boolean;
    isActive: boolean;
    createdAt: string;
}

export const addItemScheme = Joi.object({
    title: Joi.string().min(3).max(60).required().messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 60 символов`,
        "string.required": "Поле обязательно к заполнению",
    }),
    description: Joi.string().min(3).max(5000).messages({
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 5000 символов`,
    }),
    category: Joi.string().min(3).max(200).messages({
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 200 символов`,
    }),
    firstPrice: Joi.string().min(1).pattern(/^\d+$/).required().messages({
        "string.pattern.base": "Поле может содержать только числа",
        "string.min": `Минимальная длина 1 символ`,
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
    // salesPrice: Joi.number().positive().required()
})

