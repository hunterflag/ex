package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

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
//@PropertySource(value="classpath:application.yml")
public class ApplicationDemo implements CommandLineRunner{
	@Value("${company.name}")
	String companyName;
	/*
	 * Web Container 已經啟用
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DevTool.showMessages("compane.name", companyName);
	}


}
