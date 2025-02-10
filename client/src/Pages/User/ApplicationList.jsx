import React, {  useContext,useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Context from '../../Context/Context';

const ApplicationList = () => {

  const navigate = useNavigate();
  const [applications, setApplications] = useState([]);

  const { userId } = useContext(Context);
  console.log("User Id => " + userId);

  const fetchApplicationList = () =>{
   
    axios.get(`http://localhost:3000/application/user/${userId}`)
    .then(response => {
      setApplications(response.data);
      console.log(response);
    })
    .catch(error => {
      console.error('Error fetching applications:', error);
    });

  }

  useEffect(() => {
    fetchApplicationList();
  }, []);

  const handleModal = ( applicationId ) => {
    console.log(applicationId);
  }

  const handleDownloadPdf = (id, status) => {
    if (status === 'COMPLETED') {
      navigate(`/home/applicationpdf/${id}`);
    }
  };

  return (
    <div className='container mt-4'>
      <h2>Application List</h2>
      <table className='table table-bordered'>
        <thead>
          <tr>
            <th>Application ID</th>
            <th>User ID</th>
            <th>Occupation</th>
            <th>Status</th>
            <th>Submission Date</th>
            <th>Completion Date</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {applications.length > 0 ? (
            applications.map(app => (
              <tr key={app.applicationId}>
                <td>{app.applicationId}</td>
                <td>{app.userId}</td>
                <td>{app.occupation}</td>
                <td>{app.applicationStatus}</td>
                <td>{app.submissionDate || '-'}</td>
                <td>{app.completionDate || '-'}</td>
                <td>
                  <button className='btn btn-info me-2' onClick={() => handleModal(app.applicationId)}>View Details</button>
                  <button className='btn btn-success' onClick={() => handleDownloadPdf(app.applicationId, app.applicationStatus)} disabled={app.applicationStatus !== 'COMPLETED'}>Download PDF</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan='7' className='text-center'>No applications found</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ApplicationList;
