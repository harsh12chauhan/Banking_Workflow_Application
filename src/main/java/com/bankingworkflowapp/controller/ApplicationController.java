package com.bankingworkflowapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingworkflowapp.dto.ApplicationDTO;
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
	
//	@PostMapping("/create")
//	public ApplicationDTO createApplication(@RequestBody Application application) {
//		return applicationService.createApplicationService(application);
//	}
//	
//	@PatchMapping("/update/{id}")
//	public ApplicationDTO updateApplication(@PathVariable int id, @RequestBody Application application) {
//		return applicationService.updateApplicationService(id, application);
//	}
	
	
}
