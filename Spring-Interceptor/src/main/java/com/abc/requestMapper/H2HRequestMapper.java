package com.abc.requestMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abc.domain.ApplicationDetails;
import com.abc.domain.CustomerContact;
import com.abc.domain.CustomerDetails;
import com.abc.helper.HelperConverter;
import com.abc.request.ApplicationDetailsRequest;
import com.abc.request.CustomerContactRequest;
import com.abc.request.CustomerDetailsRequest;

@Component
public class H2HRequestMapper {

	@Autowired
	HelperConverter hlpConverter;

	public CustomerDetails saveRequestMapper(CustomerDetailsRequest customerDetails) {
		CustomerDetails custDetails = new CustomerDetails();
		List<ApplicationDetails> applicationDetailsList = new ArrayList<>();

		if (0 != customerDetails.getCustomerId()) {
			custDetails.setCustomerId(customerDetails.getCustomerId());
		}
		custDetails.setCifNumber(customerDetails.getCifNumber());
		custDetails.setCompanyName(customerDetails.getCompanyName());
		custDetails.setCompanyCode(customerDetails.getCompanyCode());
		custDetails.setRegistrationId(customerDetails.getRegistrationId());
		custDetails.setCifOpenDate(hlpConverter.StringToDateConverter(customerDetails.getCifOpenDate()));
		custDetails.setCreatedBy(customerDetails.getCreatedBy());
		custDetails.setModifiedBy(customerDetails.getModifiedBy());
		custDetails.setModifiedOn(hlpConverter.getTodaysDate());
		custDetails.setCreatedOn(hlpConverter.getTodaysDate());

		for (ApplicationDetailsRequest appItr : customerDetails.getApplicationDetails()) {
			ApplicationDetails applicationDetails = new ApplicationDetails();
			List<CustomerContact> customerContactList = new ArrayList<>();

			if (0 != appItr.getApplicationId()) {
				applicationDetails.setApplicationId(appItr.getApplicationId());
			}
			// applicationId
			applicationDetails.setProcessTypeCode(appItr.getProcessTypeCode());
			applicationDetails.setProcessStatusCode(appItr.getProcessStatusCode());
			applicationDetails.setProcessStatusDescription(appItr.getProcessStatusDescription());
			applicationDetails.setServiceCode(appItr.getServiceCode());
			applicationDetails.setServiceDescription(appItr.getServiceDescription());
			applicationDetails.setIsActive(appItr.getIsActive());
			applicationDetails.setPurpose(appItr.getPurpose());
			applicationDetails.setCancellationReason(appItr.getCancellationReason());
			applicationDetails.setModifiedBy(appItr.getModifiedBy());
			applicationDetails.setCreatedBy(appItr.getCreatedBy());
			applicationDetails.setModifiedOn(hlpConverter.getTodaysDate());
			applicationDetails.setCreatedOn(hlpConverter.getTodaysDate());

			for (CustomerContactRequest contactItr : appItr.getCustomerContactList()) {
				CustomerContact customerContact = new CustomerContact();

				if (0 != appItr.getApplicationId()) {
					customerContact.setContactId(contactItr.getContactId());
				}
				customerContact.setEmail(contactItr.getEmail());
				customerContact.setMobileNumber(contactItr.getMobileNumber());
				customerContact.setContactName(contactItr.getContactName());
				customerContact.setCreatedBy(contactItr.getCreatedBy());
				customerContact.setModifiedBy(contactItr.getModifiedBy());
				customerContact.setModifiedOn(hlpConverter.getTodaysDate());
				customerContact.setCreatedOn(hlpConverter.getTodaysDate());

				customerContactList.add(customerContact);

			}
			applicationDetails.setCustomerContactList(customerContactList);
			System.out.println(applicationDetails.getCustomerContactList().size());
			applicationDetailsList.add(applicationDetails);
		}
		custDetails.setApplicationDetails(applicationDetailsList);

		return custDetails;
	}
}
