package com.bankingworkflowapp.entity;

import java.sql.Date;

import com.bankingworkflowapp.enums.ApplicationStatus;
import com.bankingworkflowapp.enums.ApplicationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="application")
public class Application {
	
	@Id
	@Column(name="applicationid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer applicationId;
		
	@Column(name="userid",nullable = false)
    Integer userId;
	
	@Column(name="applicationstatus",nullable = false)
	@Enumerated(EnumType.STRING)
    ApplicationStatus applicationStatus;
	
	@Column(name="submissiondate")
    Date submissionDate;
	
	@Column(name="completiondate")
    Date completionDate;
	
	//LOAN ------------>
	
	@Column(name="loanamount")
	Double loanAmount;
	
	@Column(name="loanduration")
	Integer loanDuration;
	
	@Column(name="annualincome")
	Double annualIncome;
	
	@Column(name="occupation")
	String occupation;
	
	@Column(name="intrestrate")
	Double intrestRate;

	
	
	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(Double intrestRate) {
		this.intrestRate = intrestRate;
	}
}
