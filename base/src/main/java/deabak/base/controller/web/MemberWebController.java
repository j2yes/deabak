package deabak.base.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberWebController {

	@RequestMapping(value="/member.do")
	public String Member(Model model) throws Exception{
		
		return "member/member";
	}
}
