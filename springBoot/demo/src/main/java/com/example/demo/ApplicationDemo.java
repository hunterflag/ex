package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;

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
@ComponentScan(basePackages = "com.example.demo")
//@PropertySource(value="classpath:application.yml")
public class ApplicationDemo implements CommandLineRunner{
//	@Value("${company.name: unknown}")
	@Value("${same.name.different.value: unknown}")
	String sameName;

	@Value("${only.name.value: unknown}")
	String onlyNameValue;
	@Value("${only.name.default.value: unknown}")
	String onlyNameDefaultValue;
	@Value("${only.name.test.value: unknown}")
	String onlyNameTestValue;
	
//	@Value("${server.address: unknown}")
//	String serverAddress;
//	
//	@Value("${debug: defaultString}")
//	String debug;

//	@Value(true)	// 非字串
//	@Value(123)		// 非字串
//	@Value("undedfined")
//	@Value("'undedfined'")
//	String directAssignString;
	@Value("true")
//	Boolean isOn;
	boolean isOn;

	@Value("123")
//	int amount;
	Integer amount;

	
	/*
	 * Web Container 已經啟用
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DevTool.showMessages("same.name", sameName);
		DevTool.showMessages("only.name.value", onlyNameValue);
		DevTool.showMessages("only.name.default.value", onlyNameDefaultValue);
		DevTool.showMessages("only.name.test.value", onlyNameTestValue);
		DevTool.showMessages("boolean", String.valueOf(isOn));
		DevTool.showMessages("int", String.valueOf(amount));
//		DevTool.showMessages("server.address", serverAddress);
//		DevTool.showMessages("degug", debug);
//		DevTool.showMessages("directAssignString", directAssignString);
	}


}
