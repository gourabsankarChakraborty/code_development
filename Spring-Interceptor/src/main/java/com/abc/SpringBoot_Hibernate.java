package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

//@EntityScan("com.tcs")
@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@EnableCaching
public class SpringBoot_Hibernate {
 public static void main(String[] args) {
	 SpringApplication.run(SpringBoot_Hibernate.class, args);

	}

}
