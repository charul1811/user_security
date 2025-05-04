// Dashboard.js
import React, { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext';

const Dashboard = () => {
    const { user, logout } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleLogout = () => {
        logout();
        navigate('/login');
    };

    return (
        <div className="dashboard-container">
            <header>
                <h2>Welcome, {user?.name}</h2>
                <button onClick={handleLogout}>Logout</button>
            </header>
            <main>
                <h3>Dashboard Content</h3>
                <p>Email: {user?.email}</p>
                {/* Add your dashboard content here */}
            </main>
        </div>
    );
};

export default Dashboard;