package com.bankingworkflowapp.entity;

import com.bankingworkflowapp.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="userid",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;
	
	@Column(name="email",nullable = false,unique=true)
	String email;
	
	@Column(name="password",nullable = false)
	String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role",nullable = false)
	UserRole role;
	
	//setting default value of UserRole as USER
	@PrePersist
	public void setDefaultUserRole() {
		if(role == null) {
			setRole(UserRole.USER);
		}
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}

}
