package com.codingdojo.javastack.springboot.worldhistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.codingdojo.javastack.springboot.worldhistory.models.User;



@SpringBootApplication

@Controller
public class WorldHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldHistoryApplication.class, args);
	}
	
//	@GetMapping("/")
//	public String regLogin(Model model,@ModelAttribute("user") User user) {
//		model.addAttribute("user", new User());
//		return "RegLogin.jsp";
//	}
//	
//	
//	@GetMapping("/reg")
//	public String regLogintest(Model model,@ModelAttribute("user") User user) {
//		model.addAttribute("user", new User());
//		return "RegLogin2.jsp";
//	}

}
