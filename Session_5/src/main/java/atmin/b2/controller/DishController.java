package atmin.b2.controller;

import atmin.b2.model.Dish;
import atmin.b2.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping("/bai2/dish-list")
    public String getList(Model model) {
        List<Dish> list = service.getAll();
        model.addAttribute("dishes", list);
        return "dish-list";
    }
}