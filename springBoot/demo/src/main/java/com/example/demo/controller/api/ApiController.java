package com.example.demo.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value="classpath:application2.properties")
public class ApiController {
	private Logger logger = LoggerFactory.getLogger(ApiController.class);
//	@Value("Hello")
	@Value("${company.name}")
	String companyName;
	@Value("${company.name2}")
	String companyName2;
	@Value("${company.name3}")
	String companyName3;
	
	@RequestMapping(value="/api")
	public String apiIndex() {
		logger.info(companyName);
		logger.info(companyName2);
		logger.info(companyName3);
		String result="Hello API!";
		return result;
	}
}
