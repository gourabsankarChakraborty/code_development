package com.abc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.abc.dao.H2HApplicationDao;
import com.abc.domain.CustomerDetails;
import com.abc.request.CustomerDetailsRequest;
import com.abc.requestMapper.H2HRequestMapper;
import com.abc.response.CustomerDetailsResponse;
import com.abc.responseMapper.H2HResponseMapper;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;

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
		custDetailsResponse = h2hRespMapper.getCustomerInformationResponseMapper(custDetailsModel);
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

	@Override
	@Transactional
	public List<CustomerDetails> testMultithreading(Integer count) throws InterruptedException, ExecutionException {
		List<CustomerDetails> custList = new ArrayList<>();
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
			CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
			CustomerDetails customerDetails = new CustomerDetails();
			CompletableFuture<CustomerDetails> customerDetails1 = h2hDao
					.saveApplicationDetailsMultiThread(customerDetails);
			CompletableFuture.allOf(customerDetails1).join();
			if (customerDetails1.isDone()) {
				custList.add(customerDetails1.get());

			}
			/*
			 * customerDetails = h2hDao.saveApplicationDetails(customerDetails);
			 * custList.add(customerDetails);
			 */
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Total Time taken :" + (t2 - t1));
		return custList;
	}

	@Override
	@Cacheable(value = "cachedUrls")
	public Map<Integer, List<String>> getRollMapping() {
		System.out.println("cached called");
		IMap<Object,Object> map = Hazelcast.getHazelcastInstanceByName("hazelcast-instance").getMap("cachedUrls");
		Map<Integer, List<String>> urlsMapping = new HashMap<>();
		List<String> url1 = new ArrayList<>();
		List<String> url2 = new ArrayList<>();

		url1.add("testMultithreading");
		url1.add("saveData");

		url2.add("getCustomerInformation");

		urlsMapping.put(1, url1);
		urlsMapping.put(2, url2);
		
		
		map.put(1, url1);
		map.put(2, url2);

		return urlsMapping;
	}
}
