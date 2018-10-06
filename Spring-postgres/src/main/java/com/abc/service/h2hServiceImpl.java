package com.abc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.H2HApplicationDao;
import com.abc.domain.CustomerDetails;
import com.abc.model.CustomerDetailsModel;
import com.abc.request.CustomerDetailsRequest;
import com.abc.requestMapper.H2HRequestMapper;
import com.abc.response.CustomerDetailsResponse;
import com.abc.responseMapper.H2HResponseMapper;

@Service("H2H")
public class h2hServiceImpl implements H2HService {

	@Autowired
	private H2HApplicationDao h2hDao;

	@Autowired
	private H2HRequestMapper h2hReqMapper;

	@Autowired
	H2HResponseMapper h2hRespMapper;

	@Override
	public CustomerDetailsResponse saveApplicationDetails(CustomerDetailsRequest customerDetailsRequest) {
		System.out.println("Enter Into Save Service");
		CustomerDetailsResponse custDetailsResponse = new CustomerDetailsResponse();
		CustomerDetails custDetailsModel = new CustomerDetails();

		custDetailsModel = h2hDao.saveApplicationDetails(h2hReqMapper.saveRequestMapper(customerDetailsRequest));
		custDetailsResponse  = h2hRespMapper.getCustomerInformationResponseMapper(custDetailsModel);
		// h2hDao.saveApplicationDetails(custDetailsModel);
		System.out.println("Exit From  Save Service");
		return custDetailsResponse;
	}

	@Override
	public CustomerDetailsResponse getCustomerInformation(String cif) {
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
		CustomerDetails custDetails = new CustomerDetails();
		try {
			custDetails = h2hDao.getCustomerInformation(cif);
			customerDetailsResponse = h2hRespMapper.getCustomerInformationResponseMapper(custDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customerDetailsResponse;

	}
	
	
	@Override
	public CustomerDetailsResponse getApplicationDetails(Integer applicationId) {
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
		CustomerDetails custDetails = new CustomerDetails();
		
		try {
			custDetails = h2hDao.getApplicationDetails(applicationId);
			customerDetailsResponse = h2hRespMapper.getCustomerInformationResponseMapper(custDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDetailsResponse;
	}
}
