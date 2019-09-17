package com.rj.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/camel")
@Api(value = "Apache Camel")
public class camelController {

	@Autowired
	CamelContext camelContext;

	@Autowired
	ProducerTemplate producerTemplate;

	@GetMapping("transfer-file")
	public String getDetails() {
		try {

		} catch (Exception e) {
			System.out.println("Exception ");
		}
		return "success";
	}

	@GetMapping("/start-route")
	@Consumes("Application/json")
	@Produces("Application/json")
	@ApiOperation(value = "Get All Routes available in Camel context", response = String.class)
	public String startCamelRoute(@RequestParam(value = "camelRouteName", required = true) String camelRouteName)
			throws Exception {

		String status = null;
		List<String> routeIds = camelContext.getRoutes().stream().map(route -> route.getId())
				.collect(Collectors.toList());

		/*if (routeIds.contains(camelRouteName)) {
			ServiceStatus serviceStatus = camelContext.getRouteStatus(camelRouteName);
			

			if (serviceStatus.isStartable() && !serviceStatus.isStarted()) {
				camelContext.startRoute(camelRouteName);
				status = "Process";
			}
		}*/

		return status;
	}

}
