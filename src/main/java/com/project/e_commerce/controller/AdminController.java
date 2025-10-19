package com.project.e_commerce.controller;

import com.project.e_commerce.model.Product;
import com.project.e_commerce.service.OrderService;
import com.project.e_commerce.service.ProductService;
import com.project.e_commerce.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
   private final OrderService orderService;
   private final ProductService productService;
   private final UserService userService;
   
   public AdminController(OrderService orderService, ProductService productService, UserService userService) {
	   this.orderService = orderService;
	   this.productService = productService;
	   this.userService = userService;
   }
   
   @GetMapping("/dashboard")
   public String dashboard(Model model) {
	   // Add useful stats to dashboard
	   model.addAttribute("totalProducts", productService.getAllProducts().size());
	   model.addAttribute("totalOrders", orderService.getAllOrders().size());
	   model.addAttribute("totalUsers", userService.getAllUsers().size());
	   return "admin-dashboard";
   }
   
   @GetMapping("/orders")
   public String viewAllOrders(Model model) {
	   model.addAttribute("orders", orderService.getAllOrders());
	   return "admin-orders";
   }
   
   @GetMapping("/products")
   public String viewAllProducts(Model model) {
	   model.addAttribute("products", productService.getAllProducts());
	   return "admin-products";
   }
   
   @GetMapping("/products/new")
   public String createProductForm(Model model) {
	   model.addAttribute("product", new Product());
	   return "product-form";
   }
   
   @PostMapping("/products")
   public String saveProduct(@ModelAttribute("product") Product product) {
	   productService.create(product);
	   return "redirect:/admin/products?success";
   }
   
   @GetMapping("/products/edit/{id}")
   public String editProductForm(@PathVariable Long id, Model model) {
	   Product product = productService.getById(id)
	       .orElseThrow(() -> new RuntimeException("Product not found"));
	   model.addAttribute("product", product);
	   return "product-form";
   }
   
   @PostMapping("/products/delete/{id}")
   public String deleteProduct(@PathVariable Long id) {
	   productService.delete(id);
	   return "redirect:/admin/products?deleted";
   }
   
   @GetMapping("/users")
   public String viewAllUsers(Model model) {
	   model.addAttribute("users", userService.getAllUsers());
	   return "admin-users";
   }
}