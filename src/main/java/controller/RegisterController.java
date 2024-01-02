package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	@RequestMapping("/HelloWorld")
	public String getRegistration(Model model,@RequestParam("id") int id) {
		model.addAttribute("id", id);
		return "NewFile";
	}
}
