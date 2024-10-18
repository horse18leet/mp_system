type Role = {
    id: number;
    name: string;
}

interface IRegUserResponse {
    id: number;
    email: string;
    firstName: string;
    secondName: string;
    phoneNumber: string;
    isActive: boolean;
    createdAt: string;
    userPreferences: string;
    userSubscriptions: string;
    role: Role;
}

export default IRegUserResponse;