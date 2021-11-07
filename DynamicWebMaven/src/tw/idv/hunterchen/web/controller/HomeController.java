package tw.idv.hunterchen.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.idv.hunterchen.lab.dao.UserMapper;
import tw.idv.hunterchen.lab.model.User;
import tw.idv.hunterchen.utility.DebugTool;

@Controller
@RequestMapping(value={"/**", "/home" } )
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/{pathName}")
	public String home(@PathVariable("pathName") String pathName, HttpServletRequest request, Model model) {
		String result="/home/"+pathName;
		DebugTool.showMessageWithSerialNo(result);
		/*
		User user = new User();
		
		user.setName("MyHunter");
		new UserMapper().insert("ddd");
		*/
		
		return result;
	}
}
