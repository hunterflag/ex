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
@RequestMapping("/sample")
public class SampleController {
	/**
	 * 通用型 /sample/xxx
	 * 
	 * @param sampleName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/{sample}")
	public String sample(@PathVariable("sample") String sampleName, HttpServletRequest request, Model model) {
		String result="/sample/"+sampleName;
		DebugTool.showMessageWithSerialNo(result);
		
		return result;
	}

	@RequestMapping("/test")
	public String test(@Param("pageName") String pageName, HttpServletRequest request, Model model) {
		String result="test";
		DebugTool.showMessage(pageName);
		
		return result;
	}
}
