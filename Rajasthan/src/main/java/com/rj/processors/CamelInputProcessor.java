package com.rj.processors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rj.model.Customer;

public class CamelInputProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("My Processor! Get Input");
		System.out.println(Exchange.HTTP_PATH);

	/*	Customer cust = exchange.getIn().getBody(Customer.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(cust);
		
		exchange.getIn().setBody(writeValueAsString);*/

	}

	private <T> InputStream getInputStream(T obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);

		oos.writeObject(obj);
		InputStream is = new ByteArrayInputStream(baos.toByteArray());
		return is;
	}
}
