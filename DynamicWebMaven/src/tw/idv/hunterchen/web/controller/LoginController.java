package tw.idv.hunterchen.web.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.idv.hunterchen.utility.DebugTool;


@Controller
@RequestMapping("/login/**")
public class LoginController {
	
	@RequestMapping("/form")
	public String form() {
		String result="/login/form";
		DebugTool.showMessage(result);
		return result;
	}

	@RequestMapping("/login/verify")
//	public String verify(HttpRequest request, Model model) {
	public String verify(@Param("pageName") String pageName, Model model) {
//		String result="/login/verify";
		String result="/login/result";
		DebugTool.showMessage(result +" : " + model.toString() + pageName);
		return result;
	}
}
