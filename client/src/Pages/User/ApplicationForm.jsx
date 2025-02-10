import React, {  useContext,useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Context from '../../Context/Context';

const initialState = {
  loanamount: '',
  loanduration: '',
  annualincome: '',
  occupation: '',
};

const ApplicationForm = () => {

  const [formData, setFormData] = useState(initialState);
  const navigate = useNavigate();

  const { userId } = useContext(Context);
  console.log("User Id => " + userId);

  const handleChange = (e) => {
    setFormData({...formData,[e.target.name]:e.target.value});
  };

  const handleSubmit = async () => {
    
      console.log(formData);

      await axios.post(`http://localhost:3000/application/create/${userId}`, formData)
      .then(res => {
        console.log(res);
        alert('Application submitted successfully');
        setFormData(initialState);
        navigate('/home');
      })
      .catch(err => err);

  };

  return (
    <div className='container mt-4'>
      <h1>Loan Application Form</h1>
      <div className='row g-3'>
        <div className='col-md-6'>
          <label className='form-label'>Annual Income</label>
          <input type='number' className='form-control' name='annualincome' value={formData.annualincome} onChange={(e) => handleChange(e)} required />
        </div>
        <div className='col-md-6'>
          <label className='form-label'>Loan Amount</label>
          <input type='number' className='form-control' name='loanamount' value={formData.loanamount} onChange={(e) => handleChange(e)} required />
        </div>
        <div className='col-md-6'>
          <label className='form-label'>Loan Duration (months)</label>
          <input type='number' className='form-control' name='loanduration' value={formData.loanduration} onChange={(e) => handleChange(e)} required />
        </div>
        <div className='col-md-6'>
          <label className='form-label'>Occupation</label>
          <input type='text' className='form-control' name='occupation' value={formData.occupation} onChange={(e) => handleChange(e)} required />
        </div>
        <div className='col-12'>
          <button className='btn btn-primary' onClick={handleSubmit}>Submit Application</button>
        </div>
      </div>
    </div>
  );
};

export default ApplicationForm;
