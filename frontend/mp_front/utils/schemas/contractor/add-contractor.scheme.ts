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
    name: Joi.string().min(3).max(60).required(),
    type: Joi.string().min(3).max(200).required(),
    description: Joi.string().min(3).max(5000),
    // phoneNum: Joi.string().min(6).max(12),
    email: Joi.string().email({ tlds: false }),
    actualAddress: Joi.string().min(5).max(100).required(),
    cardNum: Joi.string().min(3).max(16).required(),
    isActive: Joi.boolean().required(),
    createdAt: Joi.string().min(3).max(50).required(),
});

