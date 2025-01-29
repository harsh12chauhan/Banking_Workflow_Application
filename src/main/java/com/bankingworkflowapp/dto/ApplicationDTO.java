package com.bankingworkflowapp.dto;

import java.sql.Date;

import com.bankingworkflowapp.utility.ApplicationStatus;
import com.bankingworkflowapp.utility.ApplicationType;

public class ApplicationDTO {
	
	  	private int applicationId;
	    private int userId;
	    private ApplicationType applicationType;
	    private ApplicationStatus status;
	    private Date submissionDate;
	    private Date completionDate;
	    private String currentlyAssignTo;
	    private String rejectionRemarks;
	    private String documentPath;
	    private String approvalChain;
	    
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
		public ApplicationStatus getStatus() {
			return status;
		}
		public void setStatus(ApplicationStatus status) {
			this.status = status;
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
