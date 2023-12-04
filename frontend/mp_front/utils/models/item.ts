interface IItemResponse {
  id: number;
  title: string;
  description: string;
  firstPrice: number;
  user: number; // в будущем заменить на тип User
  category: string;
  mpLink: string;
  isActive: boolean;
  createdAt: string;
};

export default IItemResponse;