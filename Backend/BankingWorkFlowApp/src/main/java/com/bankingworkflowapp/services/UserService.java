package com.bankingworkflowapp.services;

import java.util.List;

import com.bankingworkflowapp.dto.LoginDataDTO;
import com.bankingworkflowapp.dto.UserDTO;
import com.bankingworkflowapp.entity.User;

public interface UserService {
	public String loginAuthenticationService(LoginDataDTO data);
	public UserDTO userRegistrationService(User user);	
	public UserDTO getUserByUserIdService(Integer id);
	public List<UserDTO> getAllUsersService();
}
