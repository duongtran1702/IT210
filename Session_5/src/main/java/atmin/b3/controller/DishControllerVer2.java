package atmin.b3.controller;

import atmin.b2.model.Dish;
import atmin.b2.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class DishControllerVer2 {
    private final DishService service;

    public DishControllerVer2(DishService service) {
        this.service = service;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int dishId, Model model) {
        Dish dish = service.findById(dishId);

        if (dish == null) {
            return "redirect:/bai2/dish-list";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("dish") Dish dish) {
        service.update(dish);
        // Sau khi lưu xong, quay về trang danh sách (giả sử path là /bai2/dish-list)
        return "redirect:/bai2/dish-list";
    }
}