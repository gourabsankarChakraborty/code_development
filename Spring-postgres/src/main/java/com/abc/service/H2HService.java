package com.abc.service;

import com.abc.request.CustomerDetailsRequest;
import com.abc.response.CustomerDetailsResponse;

public interface H2HService {
	
	
	public CustomerDetailsResponse saveApplicationDetails(CustomerDetailsRequest CustomerDetailsRequest);

	public CustomerDetailsResponse getCustomerInformation(String cif);
	
	public CustomerDetailsResponse getApplicationDetails(Integer applicationId);
}
