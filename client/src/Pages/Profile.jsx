import React, {  useContext,useEffect, useState } from 'react';
import axios from 'axios';
import Context from '../Context/Context';

const Profile = () => {

    const { userId } = useContext(Context);
    console.log("User Id => " + userId);

    const [user, setUser] = useState(null);
    const [error, setError] = useState("");

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const response = await axios.get(`http://localhost:3000/user/${userId}`);
                setUser(response.data);
                
            } catch (err) {
                setError("Failed to fetch user data.");
                console.error("Error fetching user data:", err);
            }
        };
        fetchUser();
    }, [userId]);

    if (error) {
        return <div className="text-danger">{error}</div>;
    }

    if (!user) {
        return <div>Loading...</div>;
    }

    return (
        <div className="container mt-4">
            <h1 className="text-center">User Profile</h1>
            <div className="card p-4">
                <p><strong>User ID:</strong> {user.userId}</p>
                <p><strong>Email:</strong> {user.email}</p>
                <p><strong>Role:</strong> {user.role}</p>
            </div>
        </div>
    );
};

export default Profile;
