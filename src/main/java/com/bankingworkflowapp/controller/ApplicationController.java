package com.bankingworkflowapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingworkflowapp.dto.ApplicationDTO;
import com.bankingworkflowapp.dto.ApplicationDetailsDTO;
import com.bankingworkflowapp.entity.Application;
import com.bankingworkflowapp.entity.ApplicationDetails;
import com.bankingworkflowapp.exceptions.NoApplicationFoundException;
import com.bankingworkflowapp.services.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/all")
	public List<ApplicationDTO> getApplications(){
		return applicationService.getAllApplicationService();
	}
	
	@GetMapping("/{applicationId}")
	public ApplicationDTO getApplications(@PathVariable int applicationId){
		try {
			return applicationService.getApplicationByIdService(applicationId);
		}catch(NoApplicationFoundException e) {
			System.out.println(e.getMessage());
		}
		return new ApplicationDTO();
	}
	
	@GetMapping("/user/{userId}")
	public List<ApplicationDTO> getAllApplicationByUserId(@PathVariable int userId){
		return applicationService.getAllApplicationByUserIdService(userId);
	}
	
	@GetMapping("/details")
	public List<ApplicationDetailsDTO> getAllApplicationDetails(){
		return applicationService.getAllApplicationDetailsService();
	}
	
//	@PostMapping("/create/{userid}")
//	public Boolean createApplication(@PathVariable Integer userid,@RequestBody Application application,@RequestBody ApplicationDetails applicationDetails) {
//		applicationService.createApplicationService(application,applicationDetails);
//		return true; 
//	}
//	
//	@PatchMapping("/update/{id}")
//	public ApplicationDTO updateApplication(@PathVariable int id, @RequestBody Application application) {
//		return applicationService.updateApplicationService(id, application);
//	}
	
	
}
