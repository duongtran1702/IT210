package com.restaurant.b1.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String getAllOrders() {
        return "list";
    }

    public String getOrderById(Long id) {
        return "Detail " + id;
    }
}