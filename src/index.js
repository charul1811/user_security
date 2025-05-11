import React from 'react';
import ReactDOM from 'react-dom/client';

import reportWebVitals from './main/frontend/src/reportWebVitals';
import App from "./main/frontend/src/components/App";
import { AuthProvider } from "./main/frontend/src/components/AuthContext";
import { BrowserRouter } from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <AuthProvider>
                <App />
            </AuthProvider>
        </BrowserRouter>
    </React.StrictMode>
);

reportWebVitals();
