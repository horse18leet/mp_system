import Joi from "joi";

const schema = Joi.object({
    productName: Joi.string().required().min(2).max(50).messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": "Минимальная длина 2 символа",
        "string.max": "Максимальная длина 50 символов",
        "any.required": "Поле обязательно к заполнению",
    }),
    productCategory: Joi.string().required().min(2).max(50).messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": "Минимальная длина 2 символа",
        "string.max": "Максимальная длина 50 символов",
        "any.required": "Поле обязательно к заполнению",
    }),
    productPrice: Joi.string().required().pattern(/^\d+$/).min(1).max(12).messages({
        "string.pattern.base": "Стоимость должна содержать только числа",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 1 символ`,
        "string.max": `Максимальная длина 30 символов`,
        "any.required": "Поле обязательно к заполнению",
    }),
    productLink: Joi.string().required().pattern(/^https?:\/\/(www\.)?[a-zA-Z\d]+\.[\w\-._~:/?#[\]@!$&'()*+,;=]{2,}#?$/).min(10).max(100).messages({
        "string.pattern.base": "Ссылка должна соответствовать формату: https://example...",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 9 символ`,
        "string.max": `Максимальная длина 100 символов`,
        "any.required": "Поле обязательно к заполнению",
    }),
});
// .pattern(/^https?:\/\/(www\.)?[a-zA-Z\d]+\.[\w\-._~:/?#[\]@!$&'()*+,;=]{2,}#?$/).min(10).max(100)


export default schema;