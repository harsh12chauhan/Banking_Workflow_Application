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
@Table(name="applications")
public class Application {
	
	@Id
	@Column(name="applicationid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int applicationId;
		
	@Column(name="userid",nullable = false)
    int userId;
	
	@Column(name="applicationtype",nullable = false)
	@Enumerated(EnumType.STRING)
    ApplicationType applicationType;
	
	@Column(name="applicationstatus",nullable = false)
	@Enumerated(EnumType.STRING)
    ApplicationStatus applicationStatus;
	
	@Column(name="submissiondate")
    Date submissionDate;
	
	@Column(name="completiondate")
    Date completionDate;
	
	@Column(name="currentlyassignto")
    String currentlyAssignTo;
	
	@Column(name="rejectionremarks")
    String rejectionRemarks;
	
	@Column(name="documentpath",unique=true,nullable = false)
    String documentPath;
	
	@Column(name="approvalchain",nullable = false)
    String approvalChain;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ApplicationType getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(ApplicationType applicationType) {
		this.applicationType = applicationType;
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

	public String getCurrentlyAssignTo() {
		return currentlyAssignTo;
	}

	public void setCurrentlyAssignTo(String currentlyAssignTo) {
		this.currentlyAssignTo = currentlyAssignTo;
	}

	public String getRejectionRemarks() {
		return rejectionRemarks;
	}

	public void setRejectionRemarks(String rejectionRemarks) {
		this.rejectionRemarks = rejectionRemarks;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public String getApprovalChain() {
		return approvalChain;
	}

	public void setApprovalChain(String approvalChain) {
		this.approvalChain = approvalChain;
	}

	
	
}
