// PublicRoute.js
import React, { useContext } from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { AuthContext } from '../AuthContext';

const PublicRoute = () => {
    const { isAuthenticated } = useContext(AuthContext);

    // If user is authenticated, redirect to dashboard
    // Otherwise, render the child routes (login/signup)
    return !isAuthenticated ? <Outlet /> : <Navigate to="/dashboard" replace />;
};

export default PublicRoute;