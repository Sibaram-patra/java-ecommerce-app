package com.project.e_commerce.service.impl;

import java.util.List;
import java.time.LocalDateTime;

import com.project.e_commerce.model.*;
import com.project.e_commerce.repository.*;
import com.project.e_commerce.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired private OrderRepository orderRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private CartItemRepository cartItemRepository;
	
	@Override
	public Order placeOrder(Long userId) {
		User user=userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("User not found"));
		
		List<CartItem> items=cartItemRepository.findByUserId(userId);
		if(items.isEmpty()) {
			throw new IllegalStateException("Cart is empty");
		}
		Order order=new Order();
		order.setUser(user);
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("PENDING");
		order.setItems(items);
		
		Order saved=orderRepository.save(order);
		cartItemRepository.deleteByUserId(userId);
		return saved;
	}

	@Override
	public List<Order> getOrdersForUser(Long userId) {
		return orderRepository.findByUserId(userId);
	}
  
	@Override
	public Order updateStatus(Long orderId, String status) {
		Order order=orderRepository.findById(orderId) .orElseThrow(() -> new IllegalArgumentException("Order not found"));
		order.setStatus(status);
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
}
