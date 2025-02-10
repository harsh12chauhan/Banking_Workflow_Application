import React, { useContext } from 'react'
import { Link, Outlet, useNavigate } from 'react-router-dom';
import Context from '../../Context/Context';


const Home = () => {

  const navigate = useNavigate();

  const { userId } = useContext(Context);
  console.log("User Id => " + userId);
  
  const handleLogout = () => {
    localStorage.clear();
    navigate("/");
  }

  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary sticky-top">
        <div className="container-fluid">
          <Link className="navbar-brand" to='/home'>BANKING WF</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to='/home'>Home</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to='/home/applicationform' >Application Form</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to='/home/applicationlist' >Application List</Link>
              </li>
            </ul>
          </div>
        </div>
        <div>
          <Link className="navbar-brand" to='/home/profile'>Profile</Link>
        </div>
        <div>
          <button className='btn btn-dark btn-sm px-4 py-2 mx-2' onClick={handleLogout}>Logout</button>
        </div>
      </nav>
      <div className='contanier grid'>
        <Outlet />
      </div>
    </div>
  )
}

export default Home