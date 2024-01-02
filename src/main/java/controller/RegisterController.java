package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserDao;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private final UserDao userdao;
	
	@Autowired
	RegisterController(UserDao userdao){
		this.userdao = userdao;
	}
	
	@RequestMapping("/createUser")
	public String getRegistration(Model model,@RequestParam String username, String password) {
		String id = userdao.createUser(username, password);
		model.addAttribute("id", id);
		return "NewFile";
	}
}
