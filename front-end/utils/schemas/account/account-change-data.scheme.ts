import Joi from "joi";

export type TAccountChangeSchema = {
  firstName: string;
  lastName: string;
  email: string;
};

export const schema = Joi.object({
  firstName: Joi.string().min(3).max(60).required(),
  lastName: Joi.string().min(3).max(60).required(),
  email: Joi.string().email({ tlds: false }).required(),
});
