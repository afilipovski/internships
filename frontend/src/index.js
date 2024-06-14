import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { BrowserRouter as Router } from 'react-router-dom';
import App from './App';
import {GlobalContextProvider} from "./Context/Context";
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <GlobalContextProvider>
        <React.StrictMode>
            <App />
        </React.StrictMode>
    </GlobalContextProvider>
);