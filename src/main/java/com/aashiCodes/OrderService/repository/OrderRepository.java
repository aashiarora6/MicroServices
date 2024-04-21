package com.aashiCodes.OrderService.repository;

import com.aashiCodes.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
