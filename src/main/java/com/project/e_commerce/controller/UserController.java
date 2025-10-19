package com.project.e_commerce.controller;

import com.project.e_commerce.model.User;
import com.project.e_commerce.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
    	this.userService=userService;
    }
    
    @GetMapping
    public String listUser(Model model) {
    	model.addAttribute("users",userService.getAllUsers());
    	return "users";
    }
    
    @GetMapping("/new")
    public String createUserForm(Model model) {
    	model.addAttribute("user",new User());
    	return "user-form";
    }
    
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
    	userService.saveUser(user);
    	return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "user-form";
    }
}
