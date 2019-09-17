/*
 * Copyright Gulf Bank Kuwait. All Rights Reserved.
 * This software is the proprietary information of Gulf Bank Kuwait.
 * Use is subject to license terms.
 */
package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfiguration.
 *
 * @author TCS
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/** The header. */
	private static final String HEADER = "header";

	/** The string. */
	private static final String STRING = "string";

	/**
	 * The method to Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		ParameterBuilder host2host = null;
		List<Parameter> h2hparameter = new ArrayList<>();
		host2host = new ParameterBuilder();
		host2host.name("requestId").modelRef(new ModelRef(STRING)).parameterType(HEADER).required(true).build();
		h2hparameter.add(host2host.build());
		host2host.name("sessionId").modelRef(new ModelRef(STRING)).parameterType(HEADER).required(true).build();
		h2hparameter.add(host2host.build());
		host2host.name("channelCode").modelRef(new ModelRef(STRING)).parameterType(HEADER).required(true).build();
		h2hparameter.add(host2host.build());
		host2host.name("userName").modelRef(new ModelRef(STRING)).parameterType(HEADER).required(true).build();
		h2hparameter.add(host2host.build());
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.regex("/abc.*"))
				.build().pathMapping("/").apiInfo(apiInfo()).useDefaultResponseMessages(false)
				.globalOperationParameters(h2hparameter);
	}

	/**
	 * The method to Api info.
	 *
	 * @return the api info
	 */
	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("Host TO HOST API through Swagger UI").version("1.0").license("(C) Copyright Test")
				.description("List of all the APIs of HOST " + "TO HOST App through Swagger UI");
		return builder.build();
	}
}
