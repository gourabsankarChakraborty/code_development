package com.rj;

import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spi.RestConfiguration;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rj.model.Customer;
import com.rj.processors.CamelInputProcessor;
import com.rj.processors.CamelOutputProcessor;

@Configuration
public class CamelConfig {

	@Bean
	public RestConfiguration getRest() {
		RestConfiguration restconfig = new RestConfiguration();
		restconfig.setPort(8082);
		restconfig.setComponent("restlet");
		restconfig.setBindingMode(RestBindingMode.auto.name());
		restconfig.setHost("localhost");
		// restconfig.setContextPath("/test");
		restconfig.setBindingMode("auto");
		return restconfig;
	}

	@Bean(name = "CamelInputProcessor")
	public CamelInputProcessor getCamelInputProcessor() {
		return new CamelInputProcessor();
	}
	
	@Bean(name = "CamelOutputProcessor")
	public CamelOutputProcessor getCamelOutputProcessor() {
		return new CamelOutputProcessor();
	}
	
	
	@Bean(name = "Customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
	
	
	/*public Restlet createInboundRoot() {
	    Router router = new Router(getContext());

	    // Configuring Swagger 2 support
	    Swagger2SpecificationRestlet swagger2SpecificationRestlet
	                   = new Swagger2SpecificationRestlet(this);
	    swagger2SpecificationRestlet.setBasePath(
	                           "http://myapp.com/api/v1");
	    swagger2SpecificationRestlet.attach(router);

	    return router;
	}*/

}
