package tw.idv.hunterchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages="tw.idv.hunterchen")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
}
