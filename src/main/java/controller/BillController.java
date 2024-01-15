package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import service.DocumentDao;
import service.CarbonFootprintDao;
import service.UserDao;

@Controller
public class BillController {
	
private final CarbonFootprintDao electricitydao;
	
	@Autowired
	BillController(DocumentDao documentdao, CarbonFootprintDao electricitydao){
		this.electricitydao = electricitydao;
	}
	
	@ResponseBody
    @PostMapping("/form")
    public RedirectView handleElectricityFormUpload(@RequestParam("file") MultipartFile file,@RequestParam int electricity, int gas, int fuel_oil, String other_energy_sources) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
			electricitydao.storebill(authentication.getName(), electricity, gas, fuel_oil, other_energy_sources, bytes);
			return new RedirectView("http://localhost:8080/Project/water");
       } else {
    	   return new RedirectView("http://localhost:8080/Project/electricity");
       }
    }
	
	@PostMapping("/waterbillform")
	public RedirectView handleWaterBillFormUpload(@RequestParam("file") MultipartFile file,@RequestParam int household_water_usage,int outdoor_water_usage) throws IOException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
			documentdao.uploadwaterbill(authentication.getName(), bytes);
			electricitydao.storewaterbill(authentication.getName(), household_water_usage, outdoor_water_usage);
			return new RedirectView("http://localhost:8080/Project/recycle");
       } else {
    	   return new RedirectView("http://localhost:8080/Project/water");
       }
	}
	
	@PostMapping("/recyclebillform")
	public RedirectView handleRecycleBillFormUpload(@RequestParam("file") MultipartFile file,@RequestParam String recycling_habit,String composting_habits, String landfill_waste_generation) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
			documentdao.uploadrecyclebill(authentication.getName(), bytes);
			electricitydao.storerecyclebill(authentication.getName(), recycling_habit, composting_habits, landfill_waste_generation);
			return new RedirectView("http://localhost:8080/Project/");
       } else {
    	   return new RedirectView("http://localhost:8080/Project/recycle");
       }
	}

}