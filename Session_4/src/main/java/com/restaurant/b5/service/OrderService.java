package com.restaurant.b5.service;

import com.restaurant.b5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired // Ưu tiên Constructor Injection
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrder(Long id) {
        return orderRepository.findById(id);
    }

    public String createOrder() {
        return orderRepository.save();
    }

    public String cancelOrder(Long id) {
        return orderRepository.delete(id);
    }
}