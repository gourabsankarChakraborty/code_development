package com.rj.processors;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("myfirstProcessor")
public class FirstProcessor {

	public void createMessageAudit(Exchange exchange) throws Exception {
//		String property = getProperty(exchange, "startTime");
		
		System.out.println(exchange.getProperty("startTiming"));
		System.out.println(exchange.getProperty("idempotentKey"));
	}

	public static String getProperty(Exchange exchange, String propKey) {
		Object body = exchange.getProperty(propKey);
		String payload = null;

		if (body instanceof String) {
			payload = body.toString();
		} else {
			payload = convertPojoToJson(body);
		}

		return payload;
	}

	public static String convertPojoToJson(Object object) {
		ObjectMapper mapper = getObjectMapper();
		String json = null;

		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

	private static ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}
}
