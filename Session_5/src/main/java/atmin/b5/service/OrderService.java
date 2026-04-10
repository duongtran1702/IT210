package atmin.b5.service;

import atmin.b2.model.Dish;
import atmin.b5.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Dish getDishDetail(int id) {
        // Mọi logic tính toán thuế, phí hoặc kiểm tra nghiệp vụ phải nằm ở đây
        return repository.findById(id);
    }
}