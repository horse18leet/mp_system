import { CustomAlertProps } from "@/common/components/CustomAlert/types/alert-types";

export interface PurchaseProps {
    isOpen: boolean;
    setIsOpen: (open: boolean) => void;
    itemsList: any[];    //пока так
}