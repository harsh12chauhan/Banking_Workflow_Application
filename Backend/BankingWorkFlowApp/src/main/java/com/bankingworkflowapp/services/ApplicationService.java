package com.bankingworkflowapp.services;

import java.util.List;

import com.bankingworkflowapp.dto.ApplicationDTO;
import com.bankingworkflowapp.dto.LoanDTO;

public interface ApplicationService {
	public List<ApplicationDTO> getAllApplicationService();
	public ApplicationDTO getApplicationByIdService(Integer applicationId);
	public List<ApplicationDTO> getAllApplicationByUserIdService(Integer userId);
	public ApplicationDTO createApplicationService(Integer userId ,LoanDTO loanDetail);
	public LoanDTO getApplicationsDetailsService(Integer applicationId);
	public List<ApplicationDTO> getAllApplicationByAssignedToUserIdService(Integer userId);

}
