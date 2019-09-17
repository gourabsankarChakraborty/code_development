package com.test;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

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
public class Test_Application  {

	public static void main(String[] args) {
		
		SpringApplication.run(Test_Application.class, args);
	}
}