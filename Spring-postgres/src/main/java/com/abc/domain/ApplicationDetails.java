package com.abc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "APPLICATION_DETAILS")
public class ApplicationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APPLICATION_ID")
	private Integer applicationId;
	@Column(name = "PROCESS_TYPE_CODE")
	private String processTypeCode;
	@Column(name = "PROCESS_STATUS_CODE")
	private String processStatusCode;
	@Column(name = "PROCESS_DESCRIPTION")
	private String processStatusDescription;
	@Column(name = "SERVICE_CODE")
	private String serviceCode;
	@Column(name = "SERVICE_DESCRIPTION")
	private String serviceDescription;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@Column(name = "PURPOSE")
	private String purpose;
	@Column(name = "CANCELLATION_REASON")
	private String cancellationReason;
	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;
	private String modifiedBy;
	@Column(name = "CREATED_ON", updatable = false)
	private Date createdOn;
	private Date modifiedOn;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "APPLICATION_ID", referencedColumnName = "APPLICATION_ID")
	private List<CustomerContact> customerContactList = new ArrayList<>();

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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public List<CustomerContact> getCustomerContactList() {
		return customerContactList;
	}

	public void setCustomerContactList(List<CustomerContact> customerContactList) {
		this.customerContactList = customerContactList;
	}

	public ApplicationDetails() {
		super();

	}

	public String getProcessTypeCode() {
		return processTypeCode;
	}

	public void setProcessTypeCode(String processTypeCode) {
		this.processTypeCode = processTypeCode;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
