import React, { useRef } from 'react';
import { useReactToPrint } from 'react-to-print';
import managerSign from '../../assets/managerSign.jpg';
import cfoSign from '../../assets/cfoSign.png';
import loanOfficerSign from '../../assets/loanOfficerSign.png';
import approveStamp from '../../assets/approveStamp.jpg';

const ApplicationPdf = ({applicationId}) => {

  console.log(applicationId);
  

  const data = {
    username: 'John Doe',
    address: '123 Finance Street, Connaught Place, New Delhi - 110001',
    email: 'johndoe@example.com',
    loanAmount: 500000,
    loanDuration: 24,
    annualIncome: 1200000,
    occupation: 'Software Engineer',
    interestRate: 7,
    isApproved: true,
  };

  const {
    username,
    address,
    email,
    loanAmount,
    loanDuration,
    annualIncome,
    occupation,
    interestRate,
    isApproved,
  } = data;

  const pdfRef = useRef();
  const handlePrint = useReactToPrint({
    content: () => pdfRef.current,
    documentTitle: `${username}_Loan_Application`,
  });

  return (
    <div className="container mt-4">
      <div ref={pdfRef} style={{ padding: '20px', border: '1px solid #ccc', background: '#fff' }}>
        <h2 style={{ textAlign: 'center', color: 'red', fontWeight: 'bold' }}>APPROVAL LETTER</h2>
        <p style={{ textAlign: 'center' }}>Toll Free Number: 18001222558</p>
        <p>
          <strong>Ref:</strong> LOAN/CORRS/20/11/2025 <br />
          <strong>To:</strong> {username} <br />
          <strong>Address:</strong> {address} <br />
          <strong>Email:</strong> {email}
        </p>
        <p>Subject: Approval of Personal Loan</p>
        <p>
          Dear {username},<br />
          Greetings from Our Bank! We are pleased to inform you that your loan request for Rs. {loanAmount}/- has been approved
          with an interest rate of {interestRate}% per annum. The loan duration is {loanDuration} months, with an EMI of Rs.
          {(loanAmount / loanDuration).toFixed(2)}/-.
        </p>

        <h3>Loan Details:</h3>
        <table style={{ width: '100%', border: '1px solid #ccc', marginBottom: '20px' }}>
          <tbody>
            <tr>
              <td><strong>Loan Amount</strong></td>
              <td>Rs. {loanAmount}</td>
            </tr>
            <tr>
              <td><strong>Loan Duration</strong></td>
              <td>{loanDuration} months</td>
            </tr>
            <tr>
              <td><strong>Annual Income</strong></td>
              <td>Rs. {annualIncome}</td>
            </tr>
            <tr>
              <td><strong>Occupation</strong></td>
              <td>{occupation}</td>
            </tr>
          </tbody>
        </table>

        {isApproved && (
          <div style={{ textAlign: 'center', marginTop: '20px' }}>
            <p className='my-2'>Verified By:</p>
            <div className='d-flex justify-content-center align-items-center' >
              <div className='mx-3 my-2'>
                <img
                  src={managerSign}
                  alt="Signature"
                  style={{ width: '150px', height: '50px' }}
                />
                <p>Manager, Loan Department</p>
              </div>

              <div className='mx-3 my-2'>
                <img
                  src={cfoSign}
                  alt="Signature"
                  style={{ width: '150px', height: '50px' }}
                />
                <p>CFO, Loan Department</p>
              </div>

              <div className='mx-3 my-2'>
                <img
                  src={loanOfficerSign}
                  alt="Signature"
                  style={{ width: '150px', height: '50px' }}
                />
                <p>CFO, Loan Department</p>
              </div>
            </div>
            <div>
              <div className='mx-3 my-2'>
                <img
                  src={approveStamp}
                  alt="Signature"
                  style={{ width: '150px', height: '150px' }}
                />
              </div>
            </div>
          </div>
        )}

        <p style={{ textAlign: 'center', marginTop: '20px' }}>
          Near Railway Station, Dehu Road Cantt, Distt. Pune, Maharashtra 412101
        </p>
      </div>

      <button className="btn btn-primary mt-4" onClick={handlePrint}>Download PDF</button>
      {/* <button className="btn btn-primary mt-4" onClick={window.print()}>Download PDF</button> */}
    </div>
  );
};

export default ApplicationPdf;