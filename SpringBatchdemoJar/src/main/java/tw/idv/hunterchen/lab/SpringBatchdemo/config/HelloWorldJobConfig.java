package tw.idv.hunterchen.lab.SpringBatchdemo.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import tw.idv.hunterchen.lab.SpringBatchdemo.model.Person;
import tw.idv.hunterchen.lab.SpringBatchdemo.processor.PersonItemProcessor;

@Configuration
public class HelloWorldJobConfig {
	// 新建 Job，Spring 將自動注入 jobBuilders,stepBuilders兩個 beans
	@Bean
	public Job helloWorlJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders) {
//		return jobBuilders.get("helloWorldJob").start(helloWorldStep(stepBuilders)).build();
		return (Job) jobBuilders.get("helloWorldJob").start(helloWorldStep(stepBuilders)).build();
	}

	// 新建 Step，使用 StepBuilderFactory 建立
	@SuppressWarnings("unchecked")
	@Bean
	public Step helloWorldStep(StepBuilderFactory stepBuilders) {
		return stepBuilders.get("helloWorldStep").<Person, String>chunk(10)
				.reader(reader())
				.processor((ItemProcessor<? super Person, ? extends String>) processor())
				.writer(writer())
				.build();
	}

	// 讀取資料，指定需要讀取的資源
	@Bean
	public FlatFileItemReader<Person> reader() {
		return new FlatFileItemReaderBuilder<Person>().name("personItemReader")
				.resource(new ClassPathResource("csv/persons.csv")).delimited()
				.names(new String[] { "firstName", "lastName" }).targetType(Person.class).build();
	}

	// 處理資料
	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	// 寫入資料，指定寫入路徑檔案
	@Bean
	public FlatFileItemWriter<String> writer() {
		return new FlatFileItemWriterBuilder<String>().name("greetingItemWriter")
				.resource(new FileSystemResource("target/test-outputs/greetings.txt"))
				.lineAggregator(new PassThroughLineAggregator<>()).build();
	}
}
