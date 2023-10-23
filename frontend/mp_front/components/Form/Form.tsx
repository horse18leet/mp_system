"use client"

import "./Form.css";

import { FC, createElement } from "react";
import { ReactNode } from "react";

export type classNameType = string;
export type childrenType = ReactNode;

export interface IFormProps {
    defaultValues?: any;
    children?: childrenType;
    buttonLabel?: string;
    onSubmit?: any;
    handleSubmit?: any;
    register?: any;
    isValid?: boolean;
    isDirty?: boolean;
}

const Form: FC<IFormProps> = ({
    defaultValues,
    buttonLabel = "Submit",
    children,
    onSubmit,
    handleSubmit,
    register,
    isValid,
    isDirty,
    ...rest
}) => {
    return (
        <form noValidate className="form" onSubmit={handleSubmit(onSubmit)} {...rest}>
            {Array.isArray(children) ? children.map((child) => {
                return child.props.name
                    ? createElement(child.type, {...{
                        ...child.props,
                        register,
                        key: child.props.name,
                        containerClass: "form__input-container",
                        labelClass: "form__label",
                        inputClass: "form__input",
                        errorClass: "form__input-error",
                }}): child;}): children}
            <button disabled={!isValid || !isDirty} type="submit" className="form__button button">{buttonLabel}</button>
        </form>
  );
};

export default Form;