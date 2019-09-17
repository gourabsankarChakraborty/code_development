package com.abc.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.abc.domain.CustomerDetails;
import com.abc.request.CustomerDetailsRequest;
import com.abc.response.CustomerDetailsResponse;

public interface H2HService {
	
	
	public CustomerDetailsResponse saveApplicationDetails(CustomerDetailsRequest CustomerDetailsRequest);

	public CustomerDetailsResponse getCustomerInformation(String cif);
	
	public CustomerDetailsResponse getApplicationDetails(Integer applicationId);

	public List<CustomerDetails> testMultithreading(Integer count) throws InterruptedException, ExecutionException;

	public Map<Integer, List<String>> getRollMapping();
}
