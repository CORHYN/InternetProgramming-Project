package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import model.Activity;
import model.User;
import service.UserDao;
import service.add_activity;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final add_activity add_activity;
	private final UserDao userdao;

	@Autowired
	AdminController(add_activity add_activity,UserDao userdao) {
		this.add_activity = add_activity;
		this.userdao =  userdao;
	}
	
	@RequestMapping("/approveBills")
	public String landingPage2(Model model) {
		List<User> list = userdao.loadUserInfoForBillApproval();
		model.addAttribute("list", list);
		return "admin/approveBills/approveBills";
	}
	
	@RequestMapping("/")
	public String landingPage1() {
		return "admin/homepage/homepage";
	}
	
	@RequestMapping("/add")
	public String landingPage5() {
		return "admin/events/add_activity";
	}
	
	// String fullName, String dob,Integer phone,String address,
		@PostMapping("/activity")
		public RedirectView getRegistration(@RequestParam("file") MultipartFile file, @RequestParam String activityName,
				String activityDate, String location) throws IOException {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				add_activity.addActivity(activityName, activityDate, location, bytes);
				return new RedirectView("http://localhost:8080/Project/admin/view-activities");
			} else {
				return new RedirectView("http://localhost:8080/Project/admin/add");
			}

		}
	
	@GetMapping("/view-activities")
	public ModelAndView getall_mav() {
		List<Activity> activityList = add_activity.getAllActivities();
		ModelAndView mav = new ModelAndView("admin/activities/listofactivities");
		mav.addObject("activityList", activityList);
		return mav;
	}
	
	@PostMapping("/approveTheBills")
	public String pullUpAllBills() {
		return "Bill";
	}
}
