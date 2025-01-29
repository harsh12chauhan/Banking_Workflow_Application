package com.bankingworkflowapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.bankingworkflowapp.controller","com.bankingworkflowapp.services"})
@EntityScan(basePackages = {"com.bankingworkflowapp.entity"})
@EnableJpaRepositories(basePackages = {"com.bankingworkflowapp.repositories"})
public class BankingWorkFlowAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BankingWorkFlowAppApplication.class, args);
	}
	
}
