package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.hunterchen.utility.DevTool;

@RestController
@SpringBootApplication
public class DemoApplication {
	@RequestMapping("/")
	String index(@RequestParam("param") String param) {
		DevTool.showMessages("param", param);
		return "Hello Spring Boot!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
