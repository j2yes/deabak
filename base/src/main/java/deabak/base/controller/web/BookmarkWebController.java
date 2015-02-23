package deabak.base.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
	

@Controller
public class BookmarkWebController {
	
	@RequestMapping(value="/bookmark.do")
	public String bookmark(Model model) throws Exception{
		
		return "bookmark/bookmark";
	}
	
	
}
