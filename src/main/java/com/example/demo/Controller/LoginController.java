package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.database.UserInfo;
import com.example.demo.database.UserRepo;

@Controller
public class LoginController {
	private UserRepo repo;
	@Autowired
	public LoginController(UserRepo repo) {
		super();
		this.repo = repo;
	}
	@GetMapping("/")
	public String login(@ModelAttribute("user")UserInfo user) {
		return "login-page";
	}
	@PostMapping("/add")
	public String success(@Valid @ModelAttribute("user")UserInfo user,
			BindingResult result) {
		if(result.hasErrors()) {
			return "login-page";
		}
		else 
			{
			System.out.println(user);
			repo.save(user);
			return "home-page";
		}
	}
}




