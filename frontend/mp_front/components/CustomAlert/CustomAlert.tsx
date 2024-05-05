"use client"

import { ExclamationTriangleIcon } from "@radix-ui/react-icons";
import { RocketIcon } from "@radix-ui/react-icons"

import {
  Alert,
  AlertDescription,
  AlertTitle,
} from "@/components/ui/alert";

import { CustomAlertProps } from "./types/alert-types";

type Props = {
    errCode?: string,
    errName: string,
    errDescription?: string,
};

//const imgPath = "../../images/cross-circle-svgrepo-com.svg";        //путь до крестика

export function CustomAlert({type, title, description}: CustomAlertProps) {
  return (
    <div className="absolute left-[20px] bottom-[20px] min-w-[200px] z-50">
      <Alert variant={type === "error" ? "destructive" : "default"}>
        {
          type === "error" ?  
          <ExclamationTriangleIcon className="h-6 w-6" /> 
          :
          <RocketIcon className="h-6 w-6" /> 
        }
          <AlertTitle>{title}</AlertTitle>
          <AlertDescription className="ml-[10px]">{description}</AlertDescription>
      </Alert>
    </div>
  )
}
