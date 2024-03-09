import Joi from "joi";

export interface IAddContractor {
    name: string,
    description: string,
    type: string,
    phoneNumber: string,
    email: string,
    actualAdress: string;
    cardNumber: string;
    isActive: boolean;
    createdAt: string;
}

export const addContractorScheme = Joi.object({
    name: Joi.string().min(3).max(60).required(),
    description: Joi.string().min(3).max(5000),
    type: Joi.string().min(3).max(200),
    phoneNumber: Joi.string().min(6).max(12),
    email: Joi.string().email({ tlds: false }),
    actualAdress: Joi.string().min(5).max(100).required(),
    cardNumber: Joi.string().min(3).max(16).required(),
    isActive: Joi.boolean().required(),
    createdAt: Joi.string().min(3).max(50).required(),
});

