package com.project.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.e_commerce.model.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findByUserId(Long userId);
}
