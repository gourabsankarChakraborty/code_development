package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.request.CustomerDetailsRequest;
import com.abc.response.CustomerDetailsResponse;
import com.abc.service.H2HService;

@RestController
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
	// custDetailsRersponse = h2hService.saveApplicationDetails(customerDetails);
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

}
