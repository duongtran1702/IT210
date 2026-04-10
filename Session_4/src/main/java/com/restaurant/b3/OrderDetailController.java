package com.restaurant.b3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailController {

    /**
     * Lấy chi tiết đơn hàng theo ID sử dụng @PathVariable
     * URL ví dụ: <a href="http://localhost:8080/bai3/orders/5">...</a>
     */
    @GetMapping("/bai3/orders/{id}")
    public String getOrderDetail(@PathVariable Long id) {
        // Trả về chuỗi kết quả trực tiếp ra trình duyệt
        return "Detail order id: " + id;
    }
}