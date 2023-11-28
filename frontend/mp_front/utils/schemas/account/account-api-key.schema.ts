import Joi from "joi";

export type TAccountApiKey = {
    wbKey: string;
    ozonKey: string;
    ymKey: string;
}

export const schema = Joi.object({
    wbKey: Joi.string().optional().empty("").messages({
        "any.optional": "Поле необязательно к заполнению"
    }),
    ozonKey: Joi.string().optional().empty("").messages({
        "any.optional": "Поле необязательно к заполнению"
    }),
    ymKey: Joi.string().optional().empty("").messages({
        "any.optional": "Поле необязательно к заполнению"
    })
})
