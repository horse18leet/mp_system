import Joi from "joi";

const schema = Joi.object({
    signinEmail: Joi.string().required().pattern(/[a-zA-Z0-9_.+\-]+@[a-zA-Z0-9\-]+\.[a-z]{2,4}$/).messages({
        "string.pattern.base": "Данные должны соответствовать формату: example@example.ru",
        "string.empty": "Поле обязательно к заполнению",
        "any.required": "Поле обязательно к заполнению",
    }),
    signinPassword: Joi.string().required().min(8).max(16).messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина пароля 8 символов`,
        "string.max": `Максимальная длина пароля 16 символов`,
        "any.required": "Поле обязательно к заполнению",
    }),
});

export default schema;