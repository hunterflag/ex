package tw.idv.hunterchen.api;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.persistence.model.AppConfigModel;
import tw.idv.hunterchen.service.TestService;
import tw.idv.hunterchen.persistence.mapper.AppConfigMapper;
import tw.idv.hunterchen.utility.DevTool;

@RestController
@PropertySource(value="classpath:IndexController.properties")
@Slf4j
public class IndexController {
//	@Value("${spring.application.name}")
	@Value("${app.info.author}")
	private String appName;
	
	@Autowired
	IndexService service;	
	TestService testService = new TestService();	
	
	@RequestMapping(value={"/", "/hello"})
//	@ResponseBody
	public String index(
				  @RequestParam(defaultValue = "none") 	String name
				, @RequestHeader("Accept-Language") 	String acceptLanguage
				, @RequestHeader("User-Agent") 			String userAgent
			) {
		log.info("\n<=MBH=> Hello, 我收到了! \n {} and {} ", name, appName);
		
//		TODO AppConfigMapper appConfigMapper = new AppConfigMapper();
		AppConfigModel appConfigModel;
		
		log.info("\n<=MBH=> 從 service 取得 {} ", service.getMyAuthor());
		log.info("\n<=MBH=> 從 testService 取得 {} ", testService.getMyAuthor());
//		log.info("\n<=MBH=> 從 DB 取得 {} ", appConfigModel.);
		return "<H1>Hello World!</H1> " + name;
	}
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Value("${company.name}")
	String companyName;
	
	@Value("${company.name2}")
	String companyName2;
	
	@RequestMapping("/")
	String index(@RequestParam(value="param", defaultValue ="<H1>empty</H1>", required=false) String param) {
		String lResult=null;
		logger.info("");
		param = param==null ? "" : param ;
		DevTool.showMessages("param", param);
		DevTool.showMessages("company.name", companyName);
		DevTool.showMessages("company.name2", companyName2);
		
		return lResult;
	}


}
