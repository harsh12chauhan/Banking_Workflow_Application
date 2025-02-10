import { Navigate, Outlet } from "react-router-dom";

const UserProtectedRoute = () => {

  const token = localStorage.getItem("token"); 
  const role = localStorage.getItem("userRole"); 

  return ( token  &&  ( role === "USER" ) )  ? <Outlet /> : <Navigate to="/" replace />;
  
};

export default UserProtectedRoute;
