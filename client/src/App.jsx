import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

//Pages
import Login from './Pages/Login'
import Register from './Pages/Register'
import Home from './Pages/User/Home'
import ApplicationForm from './Pages/User/ApplicationForm'
import ApplicationList from './Pages/User/ApplicationList'
import Profile from './Pages/Profile'
import EmpHome from './Pages/Employee/EmpHome'
import ApprovalList from './Pages/Employee/ApprovalList'
import ApplicationDetails from './Pages/ApplicationDetails'
import ApplicationPdf from './Pages/User/ApplicationPdf'

//Layouts
import UserProtectedRoute from './Layouts/UserProtectedRoute'
import EmpProtectedRoute from './Layouts/EmpProtectedRoute'
import AdminProtectedRoute from './Layouts/AdminProtectedRoute'
import DashBoard from './Pages/Admin/DashBoard'
import AllApplications from './Pages/Admin/AllApplications'
import AllUsers from './Pages/Admin/AllUsers'

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />

        <Route element={<UserProtectedRoute/>}>
          <Route path="/home" element={<Home />}>
            <Route path='applicationform' element={<ApplicationForm />} />
            <Route path='applicationlist' element={<ApplicationList />} />
            <Route path='applicationpdf/:id' element={<ApplicationPdf />} />
            <Route path='profile' element={<Profile />} />
          </Route>
        </Route>

        <Route element={<EmpProtectedRoute/>}>
          <Route path="/emphome" element={<EmpHome />}>
            <Route path='approvallist' element={<ApprovalList />} />
            <Route path='applicationdetails' element={<ApplicationDetails />} />
            <Route path='profile' element={<Profile />} />
          </Route>
        </Route>

        <Route element={<AdminProtectedRoute/>}>
          <Route path="/dashboard" element={<DashBoard/>}>
            <Route path='applicationlist' element={<AllApplications/>} />
            <Route path='userlist' element={<AllUsers/>} />
            <Route path='profile' element={<Profile />} />
          </Route>
        </Route>
        
      </Routes>
    </BrowserRouter>
  )
}

export default App