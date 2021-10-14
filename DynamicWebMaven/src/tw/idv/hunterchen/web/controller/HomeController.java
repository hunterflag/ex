package tw.idv.hunterchen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/**")
public class HomeController {
	@RequestMapping("/home")
	public String welcome(Model model) {
		return "home";
	}
}
