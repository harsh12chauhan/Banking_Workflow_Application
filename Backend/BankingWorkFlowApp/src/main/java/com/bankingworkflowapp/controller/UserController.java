package com.bankingworkflowapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingworkflowapp.dto.UserDTO;
import com.bankingworkflowapp.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5000")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/{userid}")
	public UserDTO getUserByUserIdService(@PathVariable("userid") Integer userId){
		return userService.getUserByUserIdService(userId);
	}
		
}
