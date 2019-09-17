package com.abc.response;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetailsResponse {

	private Integer customerId;
	private String cifNumber;
	private String companyName;
	private String companyCode;
	private String registrationId;
	private String cifOpenDate;
	private String createdBy;
	private String modifiedBy;
	private List<ApplicationDetailsResponse> applicationDetails = new ArrayList<>();
	
	
	
	public List<ApplicationDetailsResponse> getApplicationDetails() {
		return applicationDetails;
	}
	public void setApplicationDetails(List<ApplicationDetailsResponse> applicationDetails) {
		this.applicationDetails = applicationDetails;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCifNumber() {
		return cifNumber;
	}
	public void setCifNumber(String cifNumber) {
		this.cifNumber = cifNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getCifOpenDate() {
		return cifOpenDate;
	}
	public void setCifOpenDate(String cifOpenDate) {
		this.cifOpenDate = cifOpenDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
	
}
