package tw.idv.hunterchen.web.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.idv.hunterchen.utility.DebugTool;

@Controller
//@RequestMapping("/")
public class SampleController {

	@RequestMapping("/test")
	public String test(@Param("pageName") String pageName, HttpRequest request, Model model) {
		String result="test";
		DebugTool.showMessage(pageName);
		
		return result;
		
		
	}
}
