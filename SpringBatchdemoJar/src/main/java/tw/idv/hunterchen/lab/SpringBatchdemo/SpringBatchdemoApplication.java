package tw.idv.hunterchen.lab.SpringBatchdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
// https://www.796t.com/article.php?id=89719
//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBatchdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchdemoApplication.class, args);
	}

}
