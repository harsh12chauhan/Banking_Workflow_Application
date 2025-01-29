package com.bankingworkflowapp.services;

import java.util.List;

import com.bankingworkflowapp.dto.ApplicationDTO;

public interface ApplicationService {
	public List<ApplicationDTO> getAllApplicationService();
	public ApplicationDTO getApplicationByIdService(int applicationId);
	public List<ApplicationDTO> getAllApplicationByUserIdService(int userId);
//	public ApplicationDTO createApplicationService(Application application);
//	public ApplicationDTO updateApplicationService(int id, Application application);
}
