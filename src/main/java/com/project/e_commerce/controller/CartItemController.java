package com.project.e_commerce.controller;

import com.project.e_commerce.service.CartItemService;
import com.project.e_commerce.repository.UserRepository;
import com.project.e_commerce.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartItemController {
     private final CartItemService cartItemService;
     private final UserRepository userRepository;
     
     public CartItemController(CartItemService cartItemService,UserRepository userRepository) {
    	 this.cartItemService=cartItemService;
    	 this.userRepository=userRepository;
     }
     
     @GetMapping
     public String viewCart(Model model,Principal principal) {
    	 String username = principal.getName();
         User user = userRepository.findByUsername(username).orElseThrow();

         model.addAttribute("cartItems", cartItemService.getCart(user.getId()));
         return "cart";
     }
     
     @PostMapping("/add")
     public String addToCart(@RequestParam Long productId,@RequestParam int quantity,Principal principal) {
    	 String username=principal.getName();
    	 User user=userRepository.findByUsername(username).orElseThrow();
    	 cartItemService.addToCart(user.getId(),productId,quantity);
    	 return "redirect:/cart";
     }
}
