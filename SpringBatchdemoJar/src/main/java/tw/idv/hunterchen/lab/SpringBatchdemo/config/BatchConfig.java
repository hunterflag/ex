package tw.idv.hunterchen.lab.SpringBatchdemo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {
	@Override
	public void setDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
	}

}
