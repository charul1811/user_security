import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../AuthContext'; // Assuming your AuthContext provides this hook

const Home = () => {
    const { currentUser } = useAuth(); // Get authentication state
    const navigate = useNavigate();

    // Optional: Redirect if already logged in
    React.useEffect(() => {
        if (currentUser) {
            navigate('/dashboard');
        }
    }, [currentUser, navigate]);

    return (
        <div className="home-container">
            <h1>Welcome to Our App</h1>

            {!currentUser ? (
                <div className="auth-links">
                    <Link to="/login" className="auth-button">Login</Link>
                    <Link to="/signup" className="auth-button">Sign Up</Link>
                </div>
            ) : (
                <div className="dashboard-cta">
                    <p>You're already logged in!</p>
                    <Link to="/dashboard" className="dashboard-button">
                        Go to Dashboard
                    </Link>
                </div>
            )}
        </div>
    );
};

export default Home;