package com.lindazf.smm.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class CompanyApplication {

	private static final Logger log = LoggerFactory.getLogger(CompanyApplication.class);

	public static void main(String[] args) {
		System.out.println("Spring Boot Begins");
		SpringApplication.run(CompanyApplication.class, args);
		System.out.println("Spring Boot Started");
	}


	@Bean
	public Docket swaggerConfiguration() {
		log.debug("Application is started. ");
		// return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2).select() //
				.apis(RequestHandlerSelectors.basePackage("com.lindazf")).paths(PathSelectors.regex("/api/.*"))//
				.build();
	}
}


