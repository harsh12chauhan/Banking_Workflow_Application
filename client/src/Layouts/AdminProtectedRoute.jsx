import { Navigate, Outlet } from "react-router-dom";

const AdminProtectedRoute = () => {
    const token = localStorage.getItem("token"); 
    const role = localStorage.getItem("userRole"); 

    return ( token  &&  ( role === "ADMIN" ) )  ? <Outlet /> : <Navigate to="/" replace />;
}

export default AdminProtectedRoute