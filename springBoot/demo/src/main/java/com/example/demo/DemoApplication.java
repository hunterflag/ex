package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.system.SystemProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.hunterchen.utility.DevTool;

//@EnableConfigurationProperties(SystemProperties.class)
//@PropertySource(
//        value = {
//                "classpath:application.yml"
//        },
//        factory = YamlPropertySourceFactory.class // <-- 指定為自訂的PropertySourceFactory類別
//)
@RestController
@SpringBootApplication
@PropertySource(value="classpath:application2.properties")
public class DemoApplication {
	@Value("${company.name}")
	String companyName;
	
	@RequestMapping("/")
	String index(@RequestParam(value="param", defaultValue ="<H1>empty</H1>", required=false) String param) {
		param = param==null ? "" : param ;
		DevTool.showMessages("param", param);
		DevTool.showMessages("company.name", companyName);
		return "Hello Spring Boot!" + param + companyName;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
