package tw.idv.hunterchen.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.idv.hunterchen.utility.DebugTool;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/{action}")
	public String sample(@PathVariable("action") String action, HttpServletRequest request, Model model) {
		String result="user/"+action;
		DebugTool.showMessageWithSerialNo(result);
		
		return result;
	}
}
