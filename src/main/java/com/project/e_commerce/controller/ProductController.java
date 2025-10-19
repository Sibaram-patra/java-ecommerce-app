package com.project.e_commerce.controller;

import com.project.e_commerce.model.Product;
import com.project.e_commerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
     private final ProductService productService;
     
     public ProductController(ProductService productService) {
    	 this.productService=productService;
     }
     
     @GetMapping
     public String listProducts(Model model) {
    	 model.addAttribute("products",productService.getAllProducts());
    	 return "products";
     }
     @GetMapping("/new")
     public String createProductForm(Model model) {
    	 model.addAttribute("product",new Product());
    	 return"product-form";
     }
     @PostMapping
     public String saveProduct(@ModelAttribute("product") Product product) {
    	 productService.create(product);
    	 return "redirect:/products";
     }
}
