package com.bankingworkflowapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingworkflowapp.dto.ApplicationDTO;
import com.bankingworkflowapp.dto.LoanDTO;
import com.bankingworkflowapp.services.ApplicationService;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "http://localhost:5000")
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/all")
	public List<ApplicationDTO> getApplications(){
		return applicationService.getAllApplicationService();
	}
	
	@GetMapping("/{applicationId}")
	public ApplicationDTO getApplications(@PathVariable Integer applicationId){
		return applicationService.getApplicationByIdService(applicationId);
	}
	
	@GetMapping("/user/{userId}")
	public List<ApplicationDTO> getAllApplicationByUserId(@PathVariable Integer userId){
		return applicationService.getAllApplicationByUserIdService(userId);
	}
	
	@PostMapping("/create/{userid}")
	public ApplicationDTO createApplication(@PathVariable Integer userid,@RequestBody LoanDTO loanDetail) {
		return applicationService.createApplicationService(userid,loanDetail);
	}
	
	@GetMapping("/details/{applicationId}")
	public LoanDTO updateApplication(@PathVariable Integer applicationId) {
		return applicationService.getApplicationsDetailsService(applicationId);
	}
	
	
}
