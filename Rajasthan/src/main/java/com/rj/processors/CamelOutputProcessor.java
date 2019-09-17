package com.rj.processors;

import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rj.model.Customer;


public class CamelOutputProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("My Processor! Get out");
		InputStream inputStream = (InputStream) exchange.getIn().getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		Customer cust = (Customer) mapper.readValue(inputStream, Customer.class);
		
		
		System.out.println(cust);
		exchange.getIn().setBody(cust);
	}
}
