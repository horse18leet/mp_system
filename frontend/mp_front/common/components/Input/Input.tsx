import { FC, InputHTMLAttributes } from "react";

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
    name: string;
    label?: string;
    error?: string;
    register?: any;
    containerClass?: string;
    labelClass?: string;
    inputClass?: string;
    errorClass?: string;
}

const Input: FC<InputProps> = ({
  register,
  name,
  error,
  label,
  containerClass,
  labelClass,
  inputClass,
  errorClass,
  ...rest
}) => {
    return (
    <div className={containerClass}>
      {label && <label htmlFor={name} className={labelClass}>{label}</label>}
      <input
        aria-invalid={error ? "true" : "false"}
        className={inputClass}
        {...register(name)}
        {...rest}
      />
      {error && <span className={errorClass} role="alert">{error}</span>}
    </div>
  );
};

export default Input;