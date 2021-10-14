package tw.idv.hunterchen.web.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@ComponentScan("tw.idv.hunterchen.web")
public class WebAppConfig extends WebMvcConfigurerAdapter {
	// 使用static resource
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/WEB-INF/css/");
		registry.addResourceHandler("/js/**")
				.addResourceLocations("/WEB-INF/js/");
		registry.addResourceHandler("/image/**")
				.addResourceLocations("/WEB-INF/image/");
	}
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	// 輸出 json 格式需要的 View 與 ViewResolver
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
		mappingJackson2JsonView.setPrettyPrint(true);
		return mappingJackson2JsonView;
	}
	@Bean
	public ViewResolver contentNegotiViewResolver(ContentNegotiationManager manager) {
			ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
			resolver.setContentNegotiationManager(manager);
			ArrayList<View> views = new ArrayList<>();
			views.add(jsonView());
			resolver.setDefaultViews(views);
			return resolver;
	}
}
