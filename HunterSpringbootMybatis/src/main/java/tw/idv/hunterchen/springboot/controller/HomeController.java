package tw.idv.hunterchen.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping(value={"/", "/index"})
	public String index() {
		return "Hello";
	}
}
