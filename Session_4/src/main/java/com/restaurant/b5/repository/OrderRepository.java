package com.restaurant.b5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public String findById(Long id) {
        return "Chi tiết đơn hàng số: " + id;
    }

    public String save() {
        return "Tạo đơn hàng mới thành công!";
    }

    public String delete(Long id) {
        return "Đã hủy thành công đơn hàng số: " + id;
    }
}