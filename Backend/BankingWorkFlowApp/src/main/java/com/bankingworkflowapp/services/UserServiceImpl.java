package com.bankingworkflowapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingworkflowapp.dto.LoginDataDTO;
import com.bankingworkflowapp.dto.UserDTO;
import com.bankingworkflowapp.entity.User;
import com.bankingworkflowapp.enums.UserRole;
import com.bankingworkflowapp.exceptions.InvalidUserCredentialsException;
import com.bankingworkflowapp.exceptions.UserNotFoundException;
import com.bankingworkflowapp.exceptions.UserWithEmailAlreadyExistException;
import com.bankingworkflowapp.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public String loginAuthenticationService(LoginDataDTO logindata) throws InvalidUserCredentialsException {
		
		if(logindata.getEmail() != null && logindata.getPassword() != null) {
			
			User user = userRepo.getUserByEmail(logindata.getEmail());
			
			if( user == null || !user.getPassword().equals(logindata.getPassword()) ) {
				throw new InvalidUserCredentialsException("User Credientials are Invlid !!");
			}
						
			String token = user.getUserId().toString()+ " " + user.getRole() + " " + UUID.randomUUID().toString();
			
			return token;
		}		
		return null;
	}

	
	@Override
	public UserDTO userRegistrationService(User user) throws UserWithEmailAlreadyExistException {
		
		UserDTO dto = new UserDTO();
		
		if(user != null) {
			
			String userEmail = user.getEmail();
		
			if( userRepo.getUserByEmail(userEmail) != null ) {
				throw new UserWithEmailAlreadyExistException("User with this email already exist's.");
			}
			
			User newUser = userRepo.save(user);
			BeanUtils.copyProperties(newUser, dto);
			return dto;
		}
		return dto;
	}
	
	
	@Override
	public UserDTO employeeRegistrationService(User user) throws UserWithEmailAlreadyExistException {
		
		UserDTO dto = new UserDTO();
		
		if(user != null) {
			
			String userEmail = user.getEmail();
			
			if( userRepo.getUserByEmail(userEmail) != null ) {
				throw new UserWithEmailAlreadyExistException("User with this email already exist's.");
			}
			
			user.setRole(UserRole.EMPLOYEE);
						
			User newUser = userRepo.save(user);
			BeanUtils.copyProperties(newUser, dto);
			return dto;
		}
		return dto;
	}
	
	
	@Override
	public List<UserDTO> getAllUsersService() {
		
		List<User> users = userRepo.findAll();
		
		ArrayList<UserDTO> dtoList = new ArrayList<>();
		
		for(User user:users) {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Override
	public UserDTO getUserByUserIdService(Integer userId) throws UserNotFoundException {
		
		if(userId != null) {
			
			User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not exists."));
			
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
			
			return dto;
		}
		return null;
	}
	
}
