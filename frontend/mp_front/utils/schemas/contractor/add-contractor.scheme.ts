import Joi from "joi";

export interface IAddContractor {
    name: string,
    type: string,
    description: string,
    // phoneNum?: string,
    email: string,
    actualAddress: string;
    cardNum: string;
    isActive: boolean;
    createdAt: string;
}

export const addContractorScheme = Joi.object({
    name: Joi.string().min(2).max(60).required().messages({
        // "string.pattern.base": "Поле может содержать только буквы",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 2 символа`,
        "string.max": `Максимальная длина 60 символов`,
        "string.required": "Поле обязательно к заполнению",
    }),
    type: Joi.string().min(3).max(200).required().messages({
        // "string.pattern.base": "Поле может содержать только буквы",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 20 символов`,
        "string.required": "Поле обязательно к заполнению",
    }),
    description: Joi.string().min(3).max(5000).messages({
        // "string.pattern.base": "Поле может содержать только буквы",
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 5000 символов`,
    }),
    // phoneNum: Joi.string().min(6).max(12),
    email: Joi.string().email({ tlds: false }).messages({
        "string.pattern.base": "Поле дожлно соответствовать формату электронной почты",
    }),
    actualAddress: Joi.string().min(5).max(100).required().messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 5 символов`,
        "string.max": `Максимальная длина 100 символов`,
        "string.required": "Поле обязательно к заполнению",
    }),
    cardNum: Joi.string().min(3).max(20).pattern(/^\d+$/).required().messages({
        "string.pattern.base": "Поле может содержать только числа",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 20 символов`,
        "string.required": "Поле обязательно к заполнению",
    }),
    // isActive: Joi.boolean().required(),
    // createdAt: Joi.string().min(3).max(50).required(),
});

