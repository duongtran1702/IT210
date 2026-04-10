package atmin.btth.controller;

import atmin.btth.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class PromotionController {
    @GetMapping("/promotions")
    public String showPromotions(ModelMap model) {
        List<Dish> dishList = new ArrayList<>();

        dishList.add(new Dish("Phở Bò Tái Lăn", 60000.0, 15));
        dishList.add(new Dish("Bún Chả Hà Nội", 50000.0, 10));
        dishList.add(new Dish("Bánh Mì Hội An", 35000.0, 20));
        dishList.add(new Dish("Cà Phê Trứng", 45000.0, 25));

        model.addAttribute("items", dishList);
        model.addAttribute("titlePage", "Promotion");

        return "promotions";

    }

}
