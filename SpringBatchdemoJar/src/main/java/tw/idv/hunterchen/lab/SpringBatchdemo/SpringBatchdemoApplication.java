package tw.idv.hunterchen.lab.SpringBatchdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tw.idv.hunterchen.utility.DevTool;
// https://www.796t.com/article.php?id=89719

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBatchdemoApplication implements CommandLineRunner{

	@Value("${company.name}")
	String companyName;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchdemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		DevTool.showMessages("compane.name", companyName);
	}

}
