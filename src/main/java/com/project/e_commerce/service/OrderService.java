package com.project.e_commerce.service;

import com.project.e_commerce.model.Order;
import java.util.List;

public interface OrderService {
    
	Order placeOrder(Long userId);
    List<Order> getOrdersForUser(Long userId);
    Order updateStatus(Long orderId,String status);
    List<Order> getAllOrders();
    
}
