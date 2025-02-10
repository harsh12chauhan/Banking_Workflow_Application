import React from 'react'
import { Link,useNavigate } from 'react-router-dom';

const DashBoard = () => {

  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.clear();
    navigate("/");
  }

  return (
    <div>
      <h1>DashBoard</h1>
      <h1><Link to="/dashboard/applicationlist">applicationlist</Link></h1>
      <h1><Link to="/dashboard/userlist">userlist</Link></h1>
      <h1><Link to="/dashboard/profile">profile</Link></h1>
      <button className='btn btn-dark btn-sm px-4 py-2 mx-2' onClick={handleLogout}>Logout</button>
    </div>
  )
}

export default DashBoard