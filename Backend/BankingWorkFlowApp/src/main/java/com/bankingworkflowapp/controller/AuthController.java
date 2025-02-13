package com.bankingworkflowapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingworkflowapp.dto.LoginDataDTO;
import com.bankingworkflowapp.dto.UserDTO;
import com.bankingworkflowapp.entity.User;
import com.bankingworkflowapp.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/authentication")
	public String loginAuthentication(@RequestBody LoginDataDTO data) {
		return userService.loginAuthenticationService(data);
	}
	
	
	@PostMapping("/register")
	public UserDTO userRegistration(@RequestBody User user) {
		return userService.userRegistrationService(user);
	}
	
}
