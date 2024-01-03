package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {
	@RequestMapping("/")
	public String landingPage() {
		return "homepage/homepage";
	}
	
}
