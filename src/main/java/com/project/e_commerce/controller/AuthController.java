package com.project.e_commerce.controller;

import com.project.e_commerce.model.User;
import com.project.e_commerce.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
     private final UserService userService;

	 public AuthController(UserService userService) {
		this.userService = userService;
	 }
	 
	 @GetMapping("/login")
	 public String login() {
		 return "login";
	 }
	 
	 @GetMapping("/register")
	 public String showRegisterForm(Model model) {
		 model.addAttribute("user", new User());
		 return "register";
	 }
	 
     @PostMapping("/register")
     public String processRegister(@ModelAttribute User user) {
    	 // CRITICAL FIX: Set role to "ROLE_USER" not just "USER"
    	 user.setRole("ROLE_USER");
    	 userService.saveUser(user);
    	 return "redirect:/login?registered";
     }
}