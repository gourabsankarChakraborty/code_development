package com.rj.routes;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("loggerutil")
@Configuration
public class LoggerRoutes {

	public void logme(String msg) {
		System.out.println(msg);
	}
}
