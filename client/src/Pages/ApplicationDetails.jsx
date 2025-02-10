import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ApplicationDetails = ({ applicationId }) => {
  const [application, setApplication] = useState(null); // State for application data
  const [loading, setLoading] = useState(true); // State to track loading state
  const [error, setError] = useState(null); // State for any error

  // Step 1: Fetch application details using Axios
  useEffect(() => {
    const fetchApplicationDetails = async () => {
      try {
        const response = await axios.get(`http://localhost:3000/application/details/${applicationId}`);
        setApplication(response.data); // Update state with fetched data
      } catch (err) {
        setError('Error fetching application details'); // Set error if request fails
      } finally {
        setLoading(false); // Set loading to false once the request is complete
      }
    };

    fetchApplicationDetails();
  }, [applicationId]); // Run effect when applicationId changes

  // Step 2: Handle cancellation
  // const cancelApplication = async () => {
  //   try {
  //     await axios.post(`http://localhost:3000/application/cancel/${applicationId}`);
  //     alert('Application has been cancelled');
  //     setApplication(null); // Clear application data after cancellation
  //   } catch (err) {
  //     alert('Error cancelling the application');
  //   }
  // };

  if (loading) {
    return <div>Loading application details...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  if (!application) {
    return <div>No application details found.</div>;
  }

  // Step 3: Render the application details and cancel button
  return (
    <div>
      <h2>Application Details</h2>
      <div>
        <strong>Application ID:</strong> {application.applicationId}
      </div>
      <div>
        <strong>Loan Amount:</strong> ${application.loanAmount.toFixed(2)}
      </div>
      <div>
        <strong>Loan Duration (Months):</strong> {application.loanDuration}
      </div>
      <div>
        <strong>Annual Income:</strong> ${application.annualIncome.toFixed(2)}
      </div>
      <div>
        <strong>Occupation:</strong> {application.occupation}
      </div>
      <div>
        <strong>Interest Rate:</strong> {application.interestRate}%
      </div>

      {/* Step 4: Button to cancel the application */}
      <button onClick={cancelApplication}>Cancel Application</button>
    </div>
  );
}

export default ApplicationDetails;
