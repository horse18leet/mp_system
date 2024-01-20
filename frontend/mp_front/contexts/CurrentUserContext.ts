import React, { createContext } from 'react';

type UserContextValue = {
  user: {
    firstName: string;
    lastName: string;
    email: string;
  } | null;
  setUser: (user: { firstName: string; lastName: string; email: string } | null) => void;
};

const CurrentUserContext = createContext<UserContextValue | null>(null);

export type UserContextType = typeof CurrentUserContext;
export default CurrentUserContext;