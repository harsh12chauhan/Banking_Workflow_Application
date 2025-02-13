package com.bankingworkflowapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingworkflowapp.dto.UserDTO;
import com.bankingworkflowapp.entity.User;
import com.bankingworkflowapp.services.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5000")
public class AdminController {

	@Autowired
	UserService userService;
	
	@GetMapping("/allusers")
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsersService();
	}
	
	@PostMapping("/register-emp")
	public UserDTO employeeRegistration(@RequestBody User user) {
		return userService.employeeRegistrationService(user);
	}
	
}
