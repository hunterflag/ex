package com.example.demo.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource(value="classpath:ApiController.properties")
public class NotBean {
	@Value("company.name")
	static String companyName;
	
	public static String getValue() {
		System.out.printf("companyName: %s", companyName);
		return companyName;
	}
	
	
	
	
}
