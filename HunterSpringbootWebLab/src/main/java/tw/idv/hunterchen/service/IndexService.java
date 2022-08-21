package tw.idv.hunterchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@PropertySource(value={"test.properties"})
@Service
@Slf4j
@Data
public class IndexService {
	@Value("${app.description}")
//	@Value("${spring.application.name}")
//	@Value("${app.info.author}")
	private String author;
	
	public String getMyAuthor() {
		log.info(author);
		return author;
	}
}
