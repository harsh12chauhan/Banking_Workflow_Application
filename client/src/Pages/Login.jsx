import React, { useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Context from '../Context/Context';

const initialLoginDetails = {
    email: "",
    password: ""
};

const Login = () => {
    const [loginDetails, setLoginDetails] = useState(initialLoginDetails);

    const { setUserId } = useContext(Context);

    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleChange = (e) => {
        setLoginDetails({ ...loginDetails, [e.target.name]: e.target.value });
    };

    const LoginRequest = async () => {
        
        try {
            const res = await axios.post('http://localhost:3000/user/authentication', loginDetails);
            if (res.data) {
                const newToken = res.data;
                localStorage.setItem("token", newToken);
                
                const userIdFromToken = newToken.split(" ")[0];
                console.log("token =>"+ newToken);
                console.log("userid =>"+ userIdFromToken);
                setUserId(userIdFromToken);

                const userRole = newToken.split(" ")[1];
                localStorage.setItem("userRole", userRole);

                if (userRole === "USER") {
                    navigate('/home');
                } else if (userRole === "EMPLOYEE") {
                    navigate('/emphome');
                } else if (userRole === "ADMIN"){
                    navigate('/dashboard')
                } else {
                    navigate('/');
                }
            }
        } catch (err) {
            if (err.response && err.response.status === 401) {
                setError("Invalid credentials. Please try again.");
            } else {
                console.error("Login error:", err);
                setError("Something went wrong. Please try again later.");
            }
        }
    };

    const handleClick = () => {
        setError("");
        setLoginDetails(initialLoginDetails);
        LoginRequest();
    };

    return (
        <div className="d-flex justify-content-center align-items-center" style={{ height: "100vh" }}>
            <div className='border border-1 border-secondary p-5 rounded-3'>
                <h1 className='text-center fw-bold'>LOGIN</h1>
                {error && <p className='text-danger text-center'>{error}</p>}
                <div className="my-3">
                    <input type="email" className="form-control" name="email" placeholder="Email" aria-label="email" value={loginDetails.email} onChange={(e) => handleChange(e)} />
                </div>
                <div className="my-3">
                    <input type="password" className="form-control w-100" name="password" placeholder="Password" aria-label="password" value={loginDetails.password} onChange={(e) => handleChange(e)} />
                </div>
                <div className="my-3">
                    <button className="btn btn-primary py-1 px-4 w-100" onClick={handleClick}>Login</button>
                </div>
                <div>
                    <p>Don't have an account? <a href='/register'>Register</a></p>
                </div>
            </div>
        </div>
    );
};

export default Login;
