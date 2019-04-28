package com.abc.response;

import java.util.ArrayList;
import java.util.List;

import com.abc.request.CustomerContactRequest;

public class ApplicationDetailsResponse {

	
	private Integer applicationId;
	private String processTypeCode;
	private String processStatusCode;
	private String processStatusDescription;
	private String serviceCode;
	private String serviceDescription;
	private Boolean isActive;
	private String purpose;
	private String cancellationReason;
	private String createdBy;
	private String modifiedBy;
	private List<CustomerContactResponse> customerContactList = new ArrayList<>();
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public String getProcessTypeCode() {
		return processTypeCode;
	}
	public void setProcessTypeCode(String processTypeCode) {
		this.processTypeCode = processTypeCode;
	}
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	public String getProcessStatusDescription() {
		return processStatusDescription;
	}
	public void setProcessStatusDescription(String processStatusDescription) {
		this.processStatusDescription = processStatusDescription;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getCancellationReason() {
		return cancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
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
	public List<CustomerContactResponse> getCustomerContactList() {
		return customerContactList;
	}
	public void setCustomerContactList(List<CustomerContactResponse> customerContactList) {
		this.customerContactList = customerContactList;
	}
	
	
}
