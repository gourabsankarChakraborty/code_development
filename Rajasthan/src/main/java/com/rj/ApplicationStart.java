package com.rj;

import org.apache.camel.CamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rj.routes.Router;

@SpringBootApplication
public class ApplicationStart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = SpringApplication.run(ApplicationStart.class, args);
		
		
		
	}

}
