package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import model.Activity;
import model.ElectricityBIll;
import model.RecycleBill;
import model.User;
import model.WaterBill;
import service.CarbonFootprintDao;
import service.UserDao;
import service.add_activity;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	RestTemplate restTemplate;

	private final add_activity add_activity;
	private final UserDao userdao;
	private final CarbonFootprintDao carbondao;

	@Autowired
	AdminController(add_activity add_activity, UserDao userdao, CarbonFootprintDao carbondao) {
		this.add_activity = add_activity;
		this.userdao = userdao;
		this.carbondao = carbondao;
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

	@PostMapping(value = "/approveTheBills", params = {"email"})
	public String pullUpAllBills(Model model, @RequestParam String email) {
		List<ElectricityBIll> electricity_list = carbondao.getElectricityBill(email);
		List<WaterBill> water_list = carbondao.getWaterBill(email);
		List<RecycleBill> recycle_list = carbondao.getRecycleBill(email);
		model.addAttribute("electricity_list", electricity_list);
		model.addAttribute("water_list", water_list);
		model.addAttribute("recycle_list", recycle_list);
		return "admin/approveBills/Bills";
	}

	@PostMapping(value = "/approveTheBills", params = {"email","choice","type","id"})
	public String pullUpAllBills(Model model, @RequestParam String email,String choice,String type,int id) {
		System.out.print(email);
		System.out.print(choice);
		if(type.equals("electricity")) {
			if(choice.equals("approved")) {
				carbondao.updateElectricityStatusApproved(email,id);
			}else if(choice.equals("rejected")) {
				carbondao.updateElectricityStatusRejected(email,id);
			}
		}else if(type.equals("water")) {
			if(choice.equals("approved")) {
				carbondao.updateWaterStatusApproved(email,id);
			}else if(choice.equals("rejected")) {
				carbondao.updateWaterStatusRejected(email,id);
			}
		}else if(type.equals("recycle")) {
			if(choice.equals("approved")) {
				carbondao.updateRecycleStatusApproved(email,id);
			}else if(choice.equals("rejected")) {
				carbondao.updateRecycleStatusRejected(email,id);
			}
		}
		
		List<ElectricityBIll> electricity_list = carbondao.getElectricityBill(email);
		List<WaterBill> water_list = carbondao.getWaterBill(email);
		List<RecycleBill> recycle_list = carbondao.getRecycleBill(email);
		model.addAttribute("electricity_list", electricity_list);
		model.addAttribute("water_list", water_list);
		model.addAttribute("recycle_list", recycle_list);
		return "admin/approveBills/Bills";
	}
	
}
