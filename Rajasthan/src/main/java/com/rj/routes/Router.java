package com.rj.routes;

import org.apache.camel.builder.RouteBuilder;

public class Router extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
//		restConfiguration().h
		
		System.out.println(" router configration");
//		from("direct:firstRoute")
//			.log("Camel body: ${body}");
//		from("file:C://inputFolder?noop=true").to("file:C://outputFolder");
	}
	
	/*
	 * from("timer:hello?period={{timer.period}}").routeId("hello").group(
	 * "hello-group") .transform().method("myBean", "saySomething")
	 * .filter(simple("${body} contains 'foo'")) .to("log:foo") .end()
	 * .to("stream:out");
	 */

}
