package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Customer;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/abc")
@Api(value = "HOST TO HOST")
public class ApplicationController {

	@GetMapping("/getCustomerInformation")
	public String getCustomerInformation() throws InterruptedException {
		Thread.sleep(950);
		String str = "Application running in full swing";
		System.out.println(str + " at test");
		return str;
	}

	@GetMapping("/printRequestParam")
	public String printRequestParam(@RequestParam String input) throws InterruptedException {
		String str = "printRequestParam running in input " + input;
		System.out.println(input + " is Printing RequestParam");
		return str;
	}

	@GetMapping("/{path}/printPathVariable")
	public String printPathVariable(@PathVariable String path) throws InterruptedException {
		String str = "printPathVariable running in Doamin " + path;
		System.out.println(path + " Domain is Printing printPathVariable");
		return str;
	}

	@PostMapping("/updatecustomer")
	public Customer updatecustomer(@RequestBody Customer cust) throws InterruptedException {
		System.out.println(" Update Customer called");
		cust.setName(cust.getName() + " " + "Gourab");
		return cust;
	}

}
