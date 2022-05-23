package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableConfigurationProperties(SystemProperties.class)
//@PropertySource(
//        value = {
//                "classpath:application.yml"
//        },
//        factory = YamlPropertySourceFactory.class // <-- 指定為自訂的PropertySourceFactory類別
//)
//@RestController
@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
//@PropertySource(value="classpath:application.yml")
public class ApplicationDemo {
	
	/*
	 * Web Container 已經啟用
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}


}
