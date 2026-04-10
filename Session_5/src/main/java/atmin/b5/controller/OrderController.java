package atmin.b5.controller;


import atmin.b2.model.Dish;
import atmin.b5.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bai5")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/detail/{id}")
    public String getOrderDetail(@PathVariable int id, Model model) {
        Dish dish = service.getDishDetail(id);

        if (dish == null) {
            model.addAttribute("errorMessage", "Mã đơn hàng #" + id + " không tồn tại trong hệ thống!");
            return "error-page";
        }

        model.addAttribute("dish", dish);
        return "dish-detail";
    }
}