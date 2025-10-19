package com.project.e_commerce.controller;

import com.project.e_commerce.model.User;
import com.project.e_commerce.service.OrderService;
import com.project.e_commerce.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController {
	private final OrderService orderService;
    private final UserRepository userRepository;
 
    public OrderController(OrderService orderService, UserRepository userRepository) {
		this.orderService = orderService;
		this.userRepository = userRepository;
	}

	@GetMapping
    public String listOrder(Model model ,Principal principal) {
		String username=principal.getName();
		User user=userRepository.findByUsername(username).orElseThrow();
    	model.addAttribute("orders",orderService.getOrdersForUser(user.getId()));
    	return "orders";
    }
    
    @PostMapping("/place")
    public String placeOrder(Principal principal) {
    	String username=principal.getName();
    	User user=userRepository.findByUsername(username).orElseThrow();
    	orderService.placeOrder(user.getId());
    	return "redirect:/orders";
    }
}
