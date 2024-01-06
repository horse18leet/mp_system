"use client"

import { ExclamationTriangleIcon } from "@radix-ui/react-icons";
import { Button } from "@/components/ui/button";

import {
  Alert,
  AlertDescription,
  AlertTitle,
} from "@/components/ui/alert";

type Props = {
    errCode?: string,
    errName: string,
    errDescription?: string,
};

//const imgPath = "../../images/cross-circle-svgrepo-com.svg";        //путь до крестика

export function CustomError({errCode, errName, errDescription}: Props) {
  return (
    <div className="absolute left-[20px] bottom-[20px] min-w-[200px]">
        <Alert variant="destructive">
            <ExclamationTriangleIcon className="h-4 w-4" />
            <AlertTitle>{errName}</AlertTitle>
            <AlertDescription>
                {errDescription}
            </AlertDescription>
    </Alert>
    </div>
  )
}
