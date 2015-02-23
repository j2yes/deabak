package deabak.base.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWebController {
	

	@RequestMapping(value="/hello.do")
	public String Hello(Model model) throws Exception{
		
		
		return "hello/hello";
	}
	
	
}
