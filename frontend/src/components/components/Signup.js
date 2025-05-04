// Signup.js

import {useAuth} from "../AuthContext";
import {fullFormats as newUser} from "ajv-formats/src/formats";

const { login } = useAuth();

const handleSignup = async () => {
    // First handle signup with your backend
    // Then automatically login:
    await login(newUser.email, newUser.password);
};