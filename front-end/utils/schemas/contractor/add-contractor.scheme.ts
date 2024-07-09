import Joi from "joi";

export interface IAddContractor {
    name: string,
    type: string,
    description: string,
<<<<<<< Updated upstream
    // phoneNum?: string,
=======
    phoneNum: string,
>>>>>>> Stashed changes
    email: string,
    actualAddress: string;
    paymentNum: string;
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
<<<<<<< Updated upstream
    // phoneNum: Joi.string().min(6).max(12),
=======
    phoneNum: Joi.string().required().pattern(/^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$/).messages({
        "string.pattern.base": "Данные должны соответствовать формату: 8 777 66 55",
        "string.empty": "Поле обязательно к заполнению",
        "string.required": "Поле обязательно к заполнению",
    }),
>>>>>>> Stashed changes
    email: Joi.string().email({ tlds: false }).messages({
        "string.pattern.base": "Поле дожлно соответствовать формату электронной почты",
    }),
    actualAddress: Joi.string().min(5).max(100).required().messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 5 символов`,
        "string.max": `Максимальная длина 100 символов`,
        "string.required": "Поле обязательно к заполнению",
    }),
    paymentNum: Joi.string().min(3).max(20).pattern(/^\d+$/).required().messages({
        "string.pattern.base": "Поле может содержать только числа",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 3 символа`,
        "string.max": `Максимальная длина 20 символов`,
        "string.required": "Поле обязательно к заполнению",
    }),
    // isActive: Joi.boolean().required(),
    // createdAt: Joi.string().min(3).max(50).required(),
});

