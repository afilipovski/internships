import React from 'react';

import { createContext, useContext, useState } from 'react';

export const GlobalContext = createContext({
    user: { name: '', email: '', index:'' },
});

export const GlobalContextProvider = ({ children }) => {
    const [user, setUser] = useState({
        email: '',
        name: '',
        index:''
    });

    return (
        <GlobalContext.Provider value={{ user, setUser }}>
            {children}
        </GlobalContext.Provider>
    );
};

