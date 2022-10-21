package tw.idv.hunterchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages="tw.idv.hunterchen")
public class SpringbootDemoWebLab {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoWebLab.class, args);
	}
	
}
