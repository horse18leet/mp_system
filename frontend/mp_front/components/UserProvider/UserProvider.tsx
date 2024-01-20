import React, { useState, useEffect, ReactNode } from 'react';
import CurrentUserContext from '@/contexts/CurrentUserContext';
import { getUserInfo } from '@/utils/utils';

type Props = {
    children: ReactNode;
};

type ProviderProps<T> = {
    children: React.ReactNode;
  };
  
  type UserContextValue = {
    user: {
      name: string;
      email: string;
    } | null;
    setUser: (user: { name: string; email: string } | null) => void;
  };
  
type UserProviderProps = ProviderProps<UserContextValue>;


function UserProvider({ children }: UserProviderProps) {
    const [user, setUser] = useState<{ firstName: string; lastName: string; email: string } | null>(null);

    useEffect(() => {
        async function fetchUserData() {
            const response = await getUserInfo();
            const data = await response;
            setUser(data);
        }
        fetchUserData();
        console.log("user1: ", user)
    }, []);

    return (
        <CurrentUserContext.Provider value={{ user, setUser }}>
            {children}
        </CurrentUserContext.Provider>
    );
}

export default UserProvider;