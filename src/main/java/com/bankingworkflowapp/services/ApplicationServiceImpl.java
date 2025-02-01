package com.bankingworkflowapp.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingworkflowapp.dto.ApplicationDTO;
import com.bankingworkflowapp.dto.ApplicationDetailsDTO;
import com.bankingworkflowapp.entity.Application;
import com.bankingworkflowapp.entity.ApplicationDetails;
import com.bankingworkflowapp.enums.ApplicationStatus;
import com.bankingworkflowapp.enums.ApplicationType;
import com.bankingworkflowapp.exceptions.NoApplicationFoundException;
import com.bankingworkflowapp.repositories.ApplicationDetailsRepository;
import com.bankingworkflowapp.repositories.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepository applicationRepo;
	
	@Autowired
	ApplicationDetailsRepository applicationDetailsRepo;
	
	@Override
	public List<ApplicationDTO> getAllApplicationService() {
		List<Application> applictions = applicationRepo.findAll();
		ArrayList<ApplicationDTO> dtoList = new ArrayList<>();
		for(Application application:applictions) {
			ApplicationDTO dto = new ApplicationDTO();
			BeanUtils.copyProperties(application, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public ApplicationDTO getApplicationByIdService(int applicationId) {
		Application application = applicationRepo.findById(applicationId).orElseThrow(()-> new NoApplicationFoundException("Application with id: " + applicationId + " is not exists." ));
		ApplicationDTO dto = new ApplicationDTO();
		BeanUtils.copyProperties(application, dto);
		System.out.println(dto.getApplicationType());
		return dto;
	}

	@Override
	public List<ApplicationDTO> getAllApplicationByUserIdService(int userId) {
		List<Application> applictions = applicationRepo.applicationsByUserId(userId);
		ArrayList<ApplicationDTO> dtoList = new ArrayList<>();
		for(Application application:applictions) {
			ApplicationDTO dto = new ApplicationDTO();
			BeanUtils.copyProperties(application, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	@Override
	public List<ApplicationDetailsDTO> getAllApplicationDetailsService() {
		
		List<ApplicationDetails> applicationDetails = applicationDetailsRepo.findAll();
		ArrayList<ApplicationDetailsDTO> dtoList = new ArrayList<>();
		
		for(ApplicationDetails applicationDetail:applicationDetails) {
			ApplicationDetailsDTO dto = new ApplicationDetailsDTO();
			BeanUtils.copyProperties(applicationDetail, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public Boolean createApplicationService(Integer userid, Application application, ApplicationDetails applicationDetails) {
		if(application != null) {
			
			application.setUserId(userid);
			application.setSubmissionDate(Date.valueOf(LocalDate.now()));
			application.setApplicationStatus(ApplicationStatus.SUBMITTED);
			application.setCurrentlyAssignTo("Manager");
			application.setApplicationType(ApplicationType.LOAN);
			application.setDocumentPath("/documents/folder_" + application.getApplicationId());
			application.setApprovalChain("Manager, Senior Analyst, Branch Manager");
			
			Application applicationEntity = applicationRepo.save(application);
			int applicationId = applicationEntity.getApplicationId();
			
			if(applicationDetails != null) {		
				applicationDetails.setApplicationId(applicationId);
				ApplicationDetails applicationDetailsEntity = applicationDetailsRepo.save(applicationDetails);				
			}
			
			return true;
		}
		return false;
	}

}
