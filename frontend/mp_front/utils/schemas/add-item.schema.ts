import Joi from "joi";

const schema = Joi.object({
    title: Joi.string().min(3).max(60).required(),
    desc: Joi.string().min(3).max(5000),
    priceWithoutDiscount: Joi.number().positive().required(),
    

})