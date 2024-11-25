"use client"
import React, { useEffect, useState, ReactNode } from 'react';
import { DndProvider } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';

interface DndWrapperProps {
  id: string;
  children: ReactNode;
}

const DndWrapper: React.FC<DndWrapperProps> = ({ id, children }) => {
    const [context, setContext] = useState<HTMLElement | null>(null);

    useEffect(() => {
        setContext(document.getElementById(id) as HTMLElement);
    }, [id]);

    return context ? (
        <DndProvider backend={HTML5Backend} options={{ rootElement: context }}>
            {children}
        </DndProvider>
    ) : null;
};

export default DndWrapper;
