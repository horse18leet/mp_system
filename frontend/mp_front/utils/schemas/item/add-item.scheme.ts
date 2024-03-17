import Joi from "joi";

export interface IAddItem {
    title: string,
    description: string,
    category: string,
    primaryPrice: number,
    salesPrice: number,
}

export const addItemScheme = Joi.object({
    title: Joi.string().min(3).max(60).required(),
    description: Joi.string().min(3).max(5000),
    category: Joi.string().min(3).max(200),
    primaryPrice: Joi.number().positive().required(),
    salesPrice: Joi.number().positive().required()
})

