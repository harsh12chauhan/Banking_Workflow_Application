package com.bankingworkflowapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankingworkflowapp.entity.Application;
import com.bankingworkflowapp.entity.ApplicationDetails;
import com.bankingworkflowapp.enums.ApplicationType;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	
	@Query("select objApplication from Application objApplication where objApplication.userId=:userId")
	public List<Application> applicationsByUserId(int userId);
}
