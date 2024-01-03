package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/")
	public String registerPage() {
		return "LoginRegister/register";
	}
	// String fullName, String dob,Integer phone,String address,
	@PostMapping("/createUser")
	public String getRegistration(Model model,@RequestParam  String fullName, String dob,Integer phone,String address,String email, String password) {
		String id = userdao.createUser(fullName, dob, phone, address, email, password);
		return "New User Created";
	}
}
