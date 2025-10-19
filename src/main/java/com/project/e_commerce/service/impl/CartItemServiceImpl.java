package com.project.e_commerce.service.impl;

import java.util.List;

import com.project.e_commerce.model.*;
import com.project.e_commerce.repository.*;
import com.project.e_commerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired private CartItemRepository cartItemRepository;
	@Autowired private ProductRepository productRepository;
	@Autowired private UserRepository userRepository;
	
	@Override
	public CartItem addToCart(Long userId, Long productId, int quantity) {
	    User user=userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("User not found"));
	    Product product=productRepository.findById(productId).orElseThrow(()->new IllegalArgumentException("Product not found"));
	    CartItem item=new CartItem();
	    item.setUser(user);
	    item.setProduct(product);
	    item.setQuantity(quantity);
		return cartItemRepository.save(item);
	}

	@Override
	public List<CartItem> getCart(Long userId) {
		return cartItemRepository.findByUserId(userId);
	}

	@Override
	public CartItem updateQuantity(Long cartItemId, int quantity) {
		CartItem item=cartItemRepository.findById(cartItemId).orElseThrow(()->new IllegalArgumentException("Cart item not found"));
		item.setQuantity(quantity);
		return cartItemRepository.save(item);
	}

	@Override
	public void removeItem(Long cartItemId) {
	  	cartItemRepository.deleteById(cartItemId);
	}

	@Override
	public void clearCart(Long userId) {
		cartItemRepository.deleteByUserId(userId);

	}

}
