package com.bankingworkflowapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingworkflowapp.dto.ApplicationDTO;
import com.bankingworkflowapp.entity.Application;
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
	
}
