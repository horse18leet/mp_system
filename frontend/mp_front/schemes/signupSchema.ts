import Joi from "joi";

const schema = Joi.object({
    firstName: Joi.string().required().min(2).max(30).pattern(/^[A-Za-zА-Яа-яЁё\-\s]+$/).messages({
        "string.pattern.base": "Имя должно содержать только буквы",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": "Минимальная длина 2 символа",
        "string.max": "Максимальная длина 30 символов",
        "any.required": "Поле обязательно к заполнению",
    }),
    lastName: Joi.string().required().min(2).max(30).pattern(/^[A-Za-zА-Яа-яЁё\-\s]+$/).messages({
        "string.pattern.base": "Фамилия должна содержать только буквы",
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина 2 символа`,
        "string.max": `Максимальная длина 30 символов`,
        "any.required": "Поле обязательно к заполнению",
    }),
    email: Joi.string().required().pattern(/[a-zA-Z0-9_.+\-]+@[a-zA-Z0-9\-]+\.[a-z]{2,4}$/).messages({
        "string.pattern.base": "Данные должны соответствовать формату: example@example.ru",
        "string.empty": "Поле обязательно к заполнению",
        "any.required": "Поле обязательно к заполнению",
    }),
    phoneNumber: Joi.string().required().pattern(/^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$/).messages({
        "string.pattern.base": "Данные должны соответствовать формату: 8 777 66 55",
        "string.empty": "Поле обязательно к заполнению",
        "any.required": "Поле обязательно к заполнению",
    }),
    password: Joi.string().required().min(8).max(16).messages({
        "string.empty": "Поле обязательно к заполнению",
        "string.min": `Минимальная длина пароля 8 символов`,
        "string.max": `Максимальная длина пароля 16 символов`,
        "any.required": "Поле обязательно к заполнению",
    }),
});

export default schema;