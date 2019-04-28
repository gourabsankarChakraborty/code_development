package com.abc.responseMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abc.domain.ApplicationDetails;
import com.abc.domain.CustomerContact;
import com.abc.domain.CustomerDetails;
import com.abc.helper.HelperConverter;
import com.abc.request.CustomerContactRequest;
import com.abc.response.ApplicationDetailsResponse;
import com.abc.response.CustomerContactResponse;
import com.abc.response.CustomerDetailsResponse;

@Component
public class H2HResponseMapper {

	@Autowired
	HelperConverter hlpConverter;

	public CustomerDetailsResponse getCustomerInformationResponseMapper(CustomerDetails customerDetails) {
		CustomerDetailsResponse custDetailsRes = new CustomerDetailsResponse();
		List<ApplicationDetailsResponse> appDetailsRespList = new ArrayList<>();

		custDetailsRes.setCustomerId(customerDetails.getCustomerId());
		custDetailsRes.setCifNumber(customerDetails.getCifNumber());
		custDetailsRes.setCompanyName(customerDetails.getCompanyName());
		custDetailsRes.setCompanyCode(customerDetails.getCompanyCode());
		custDetailsRes.setRegistrationId(customerDetails.getRegistrationId());
		custDetailsRes.setCifOpenDate(hlpConverter.DateToStringConverter(customerDetails.getCifOpenDate()));
		custDetailsRes.setModifiedBy(customerDetails.getModifiedBy());
		custDetailsRes.setCreatedBy(customerDetails.getCreatedBy());

		for (ApplicationDetails appItr : customerDetails.getApplicationDetails()) {
			ApplicationDetailsResponse applicationDetailsResp = new ApplicationDetailsResponse();
			List<CustomerContactResponse> custContactListRespList = new ArrayList<>();

			applicationDetailsResp.setApplicationId(appItr.getApplicationId());
			applicationDetailsResp.setProcessTypeCode(appItr.getProcessTypeCode());
			applicationDetailsResp.setProcessStatusCode(appItr.getProcessStatusCode());
			applicationDetailsResp.setProcessStatusDescription(appItr.getProcessStatusDescription());
			applicationDetailsResp.setServiceCode(appItr.getServiceCode());
			applicationDetailsResp.setServiceDescription(appItr.getServiceDescription());
			applicationDetailsResp.setIsActive(appItr.getIsActive());
			applicationDetailsResp.setPurpose(appItr.getPurpose());
			applicationDetailsResp.setCancellationReason(appItr.getCancellationReason());
			applicationDetailsResp.setModifiedBy(appItr.getModifiedBy());
			applicationDetailsResp.setCreatedBy(appItr.getCreatedBy());

			for (CustomerContact contactItr : appItr.getCustomerContactList()) {
				CustomerContactResponse custContactResp = new CustomerContactResponse();

				custContactResp.setContactId(contactItr.getContactId());
				custContactResp.setEmail(contactItr.getEmail());
				custContactResp.setMobileNumber(contactItr.getMobileNumber());
				custContactResp.setContactName(contactItr.getContactName());
				custContactResp.setCreatedBy(contactItr.getCreatedBy());
				custContactResp.setModifiedBy(contactItr.getModifiedBy());
				custContactResp.setModifiedOn(hlpConverter.DateToStringConverter(contactItr.getModifiedOn()));
				custContactResp.setCreatedOn(hlpConverter.DateToStringConverter(contactItr.getCreatedOn()));

				custContactListRespList.add(custContactResp);
			}
			applicationDetailsResp.setCustomerContactList(custContactListRespList);
			appDetailsRespList.add(applicationDetailsResp);
		}

		custDetailsRes.setApplicationDetails(appDetailsRespList);
		return custDetailsRes;
	}
}
