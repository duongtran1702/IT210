package atmin.b1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/merchant")
public class RestaurantController {
    @GetMapping("/update-profile")
    public String showUpdateForm(Model model) {
        RestaurantProfile profile = new RestaurantProfile();
        model.addAttribute("restaurantProfile", profile);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("restaurantProfile") RestaurantProfile profile) {

        // In ra console để kiểm tra dữ liệu đã bind đúng chưa
        System.out.println("--- Dữ liệu nhận được ---");
        System.out.println("Tên quán: " + profile.getName());
        System.out.println("SĐT: " + profile.getPhone());
        System.out.println("Trạng thái: " + (profile.isActive() ? "Đang mở cửa" : "Đã đóng cửa"));
        return "redirect:/merchant/update-profile?success";
    }
}