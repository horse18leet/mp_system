import Joi from "joi";

const schema = Joi.object({
    name: Joi.string().required().min(2).max(50).messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": "Минимальная длина 2 символа",
        "string.max": "Максимальная длина 50 символов",
        "any.required": "Поле обязательно к заполнению",
    }),
    category: Joi.string().required().min(2).max(50).messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": "Минимальная длина 2 символа",
        "string.max": "Максимальная длина 50 символов",
        "any.required": "Поле обязательно к заполнению",
    }),
    price: Joi.string().required().pattern(/#^[0-9]+$#/).min(1).max(30).messages({
        "string.pattern.base": "Стоимость должна содержать только числа",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 1 символ`,
        "string.max": `Максимальная длина 30 символов`,
        "any.required": "Поле обязательно к заполнению",
    }),
    link: Joi.string().pattern(/^https?:\/\/(www\.)?[a-zA-Z\d]+\.[\w\-._~:/?#[\]@!$&'()*+,;=]{2,}#?$/).min(10).max(100).messages({
        "string.pattern.base": "Ссылка должна соответствовать формату: https://example...",
        "string.empty": "",
        "string.min": `Минимальная длина 9 символ`,
        "string.max": `Максимальная длина 100 символов`,
    }),
});

export default schema;