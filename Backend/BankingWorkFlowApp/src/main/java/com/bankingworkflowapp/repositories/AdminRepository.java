package com.bankingworkflowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingworkflowapp.entity.User;

public interface AdminRepository extends JpaRepository<User, Integer> {
	
}
