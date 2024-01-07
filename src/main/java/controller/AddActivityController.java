package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import service.add_activity;

@Controller
@RequestMapping("/add")
public class AddActivityController{
	
	private final add_activity  add_activity ;
	
	@Autowired
	AddActivityController(add_activity  add_activity){
		this.add_activity = add_activity;
	}

	@GetMapping("/")
	public String landingPage5() {
		return "admin/events/add_activity";
	}
	
	// String fullName, String dob,Integer phone,String address,
	@PostMapping("/activity")
	public RedirectView getRegistration(Model model,@RequestParam String activityName, String activityDate, String location) {
		add_activity.createUser(activityName, activityDate, location);
		return new RedirectView("http://localhost:8080/Project/");
	}
}
