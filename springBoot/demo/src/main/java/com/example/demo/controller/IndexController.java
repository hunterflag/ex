package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utility.NotBean;

import tw.idv.hunterchen.utility.DevTool;

@RestController
@PropertySource(value="classpath:IndexController.properties")
public class IndexController {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Value("${company.name}")
	String companyName;
	
	@Value("${company.name2}")
	String companyName2;
	
	@RequestMapping("/")
	String index(@RequestParam(value="param", defaultValue ="<H1>empty</H1>", required=false) String param) {
		
		logger.info("");
		param = param==null ? "" : param ;
		DevTool.showMessages("param", param);
		DevTool.showMessages("company.name", companyName);
		DevTool.showMessages("company.name2", companyName2);
		return "Hello Spring Boot!" + param + companyName + NotBean.getValue();
	}

}
