package com.bankingworkflowapp.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingworkflowapp.dto.ApplicationDTO;
import com.bankingworkflowapp.dto.LoanDTO;
import com.bankingworkflowapp.entity.Application;
import com.bankingworkflowapp.enums.ApplicationStatus;
import com.bankingworkflowapp.exceptions.NoApplicationFoundException;
import com.bankingworkflowapp.repositories.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepository applicationRepo;
		
	
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
	public List<ApplicationDTO> getAllApplicationByUserIdService(Integer userId) {
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
	public ApplicationDTO getApplicationByIdService(Integer applicationId) {
		Application application = applicationRepo.findById(applicationId).orElseThrow(()-> new NoApplicationFoundException("Application with id: " + applicationId + " is not exists." ));
		ApplicationDTO dto = new ApplicationDTO();
		BeanUtils.copyProperties(application,dto);
		return dto;
	}
	
	
	@Override
	public LoanDTO getApplicationsDetailsService(Integer applicationId) {
		if(applicationId != null) {
			Application application = applicationRepo.findById(applicationId).orElseThrow(()-> new NoApplicationFoundException("Application with id: " + applicationId + " is not exists." ));
			if(application != null) {
				LoanDTO loan = new LoanDTO();
				BeanUtils.copyProperties(application,loan);
				return loan;
			}
		}
		return null;
	}


	@Override
	public ApplicationDTO createApplicationService(Integer userId, LoanDTO loanDetail) {
	
		if(loanDetail != null) {
			
			Application application = new Application();
			
			application.setUserId(userId);
			application.setApplicationStatus(ApplicationStatus.SUBMITTED);
			application.setSubmissionDate(Date.valueOf(LocalDate.now()));
			application.setLoanAmount(loanDetail.getLoanAmount());
			application.setLoanDuration(loanDetail.getLoanDuration());
			application.setAnnualIncome(loanDetail.getAnnualIncome());
			application.setOccupation(loanDetail.getOccupation());
			application.setIntrestRate(7.0);
			
			Application applicationEntity = applicationRepo.save(application);
			
			ApplicationDTO dto = new ApplicationDTO();
			BeanUtils.copyProperties(applicationEntity,dto);
			return dto;
		}
		return new ApplicationDTO();
	}
}
