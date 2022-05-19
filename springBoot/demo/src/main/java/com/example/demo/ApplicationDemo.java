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
//@RestController
@SpringBootApplication
@PropertySource(value="classpath:application.yml")
public class ApplicationDemo {
	
	/*
	 * Web Container 已經啟用
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}


}
