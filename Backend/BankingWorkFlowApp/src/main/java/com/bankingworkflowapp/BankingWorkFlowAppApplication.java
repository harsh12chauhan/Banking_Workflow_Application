package com.bankingworkflowapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.bankingworkflowapp.controller",
    "com.bankingworkflowapp.services",
    "com.bankingworkflowapp.aop" 
})
@EntityScan(basePackages = {"com.bankingworkflowapp.entity"})
@EnableJpaRepositories(basePackages = {"com.bankingworkflowapp.repositories"})
@EnableAspectJAutoProxy
public class BankingWorkFlowAppApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(BankingWorkFlowAppApplication.class, args);
    }
}
