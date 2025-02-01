package com.bankingworkflowapp.services;

import java.util.List;

import com.bankingworkflowapp.dto.ApplicationDTO;
import com.bankingworkflowapp.dto.ApplicationDetailsDTO;
import com.bankingworkflowapp.entity.Application;
import com.bankingworkflowapp.entity.ApplicationDetails;

public interface ApplicationService {
	public List<ApplicationDTO> getAllApplicationService();
	public ApplicationDTO getApplicationByIdService(int applicationId);
	public List<ApplicationDTO> getAllApplicationByUserIdService(int userId);
		
	public List<ApplicationDetailsDTO> getAllApplicationDetailsService();
	
	public Boolean createApplicationService(Integer userid,Application application,ApplicationDetails applicationDetails);

}
