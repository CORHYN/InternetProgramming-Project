package controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {
	@RequestMapping("/")
	public String landingPage() {
		return "customer/homepage/homepage";
	}
	
	@RequestMapping("/recycle")
	public String landingPage2() {
		return "customer/recycle/RecycleActivity";
	}
	
	
	@RequestMapping("/electricity")
	public String landingPage3() {
		return "customer/electricity/ElectricityCons";
	}
	
	@RequestMapping("/water")
	public String landingPage4() {
		return "customer/water/WaterManagment";
	}
	
<<<<<<< HEAD
	@RequestMapping("/add")
	public String landingPage5() {
		return "admin/add_activity";
	}
=======
	
>>>>>>> 6f2509519b57a73380cf1227bbb1b8afbfb31d0f
}
