package tw.idv.hunterchen.springboot.simple_web;
/* 失敗, 不知原因 
 * TODO  https://www.baeldung.com/spring-boot-testing  似乎有解
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.api.IndexController;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class SimpleWebApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void before(){
		log.info("...before...");
		System.out.printf("<=MBH=> %s %n", "before");
		mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}
	
	@Test
	void contextLoads() throws Exception {
		log.info("...test...");
		System.out.printf("<=MBH=> %s %n", "test");
		mockMvc.perform( MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON) )
			   .andExpect(status().isOk())
			   .andExpect(content().string(equalTo("Hello World")));
	}

}
