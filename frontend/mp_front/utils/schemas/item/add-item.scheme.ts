import Joi from "joi";

export interface IAddItem {
    name: string,
    description: string,
    category: string,
    primary_price: number,
    sales_price: number,
}

export const addItemScheme = Joi.object({
    name: Joi.string().min(3).max(60).required(),
    description: Joi.string().min(3).max(5000),
    category: Joi.string().min(3).max(200),
    primaryPrice: Joi.number().positive().required(),
    salesPrice: Joi.number().positive().required()
})

