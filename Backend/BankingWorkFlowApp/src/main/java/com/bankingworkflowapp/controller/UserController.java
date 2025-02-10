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

import com.bankingworkflowapp.dto.LoginDataDTO;
import com.bankingworkflowapp.dto.UserDTO;
import com.bankingworkflowapp.entity.User;
import com.bankingworkflowapp.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5000")
public class UserController {
	
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
	
	@GetMapping("/")
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsersService();
	}
	
	@GetMapping("/{userid}")
	public UserDTO getUserByUserIdService(@PathVariable("userid") Integer userId){
		return userService.getUserByUserIdService(userId);
	}
	
}
