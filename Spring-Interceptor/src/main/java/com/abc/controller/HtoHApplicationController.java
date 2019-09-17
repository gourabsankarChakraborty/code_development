package com.abc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.AccessControl;
import com.abc.domain.CustomerDetails;
import com.abc.model.CustomAccess;
import com.abc.request.CustomerDetailsRequest;
import com.abc.response.CustomerDetailsResponse;
import com.abc.service.H2HService;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/h2h")
@Api(value = "HOST TO HOST")
public class HtoHApplicationController {

	@Autowired
	H2HService h2hService;

	@CrossOrigin
	@PostMapping("/saveData")
	public CustomerDetailsResponse saveApplicationDetails(@RequestBody CustomerDetailsRequest customerDetails) {

		CustomerDetailsResponse custDetailsRersponse = null;
		try {
			custDetailsRersponse = h2hService.saveApplicationDetails(customerDetails);
		} catch (Exception e) {
			System.out.println("Its errors");
			e.printStackTrace();
		}

		return custDetailsRersponse;

	}

	@GetMapping("/getCustomerInformation")
	public CustomerDetailsResponse getCustomerInformation(@RequestParam("cif") String cif) {
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();

		customerDetailsResponse = h2hService.getCustomerInformation(cif);

		return customerDetailsResponse;
	}

	// @PostMapping("/saveCustomerInfo")
	// public CustomerDetailsResponse saveCustomerInfo(@RequestBody
	// CustomerDetailsRequest customerDetails) {
	//
	// CustomerDetailsResponse custDetailsRersponse = null;
	// try {
	// custDetailsRersponse =
	// h2hService.saveApplicationDetails(customerDetails);
	// } catch (Exception e) {
	// System.out.println("Its error");
	// e.printStackTrace();
	// }
	//
	// return custDetailsRersponse;
	//
	// }

	@GetMapping("/getApplicationDetails")
	public CustomerDetailsResponse getApplicationDetails(@RequestParam("applicationId") Integer applicationId) {
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();

		customerDetailsResponse = h2hService.getApplicationDetails(applicationId);

		return customerDetailsResponse;
	}

	@PostMapping("/testMultithreading")
	public List<CustomerDetails> testMultithreading()
			throws InterruptedException, ExecutionException {
		h2hService.getRollMapping();
		IMap<Object, Object> map = Hazelcast.getHazelcastInstanceByName("hazelcast-instance").getMap("cachedUrls");
		Object object = map.get(1);
		System.out.println(object);

		return h2hService.testMultithreading(1);

	}

//	@ModelAttribute()
//	public CustomAccess getUrls(HttpServletRequest request) {
//
//		CustomAccess customAccess = new CustomAccess();
//		System.out.println("Model Attribute called");
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/") + 1);
//		System.out.println(path);
//
//		Map<Integer, List<String>> urlsMapping = new HashMap<>();
//		urlsMapping = h2hService.getRollMapping();
//		customAccess.setHasAccess(false);
//		return customAccess;
//
//	}

}
