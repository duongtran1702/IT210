package com.restaurant.b5.controller;

import com.restaurant.b5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("/bai5")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Route 1: Xem đơn hàng
    @GetMapping("/orders/{id}")
    public String viewOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    // Route 2: Tạo đơn hàng
    @PostMapping("/orders")
    public String makeOrder() {
        return orderService.createOrder();
    }

    // Route 3: Hủy đơn hàng
    @DeleteMapping("/orders/{id}")
    public String removeOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch() {
        return "ID đơn hàng phải là một số. Vui lòng kiểm tra lại!";
    }
}