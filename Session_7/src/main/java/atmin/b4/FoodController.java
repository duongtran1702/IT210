package atmin.b4;

import atmin.b3.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/food")
public class FoodController {
    private static final List<Food> foodList = new ArrayList<>();

    @GetMapping("/add")
    public String showForm() {
        return "add-food"; // Trả về view form thêm món ăn
    }

    @PostMapping("/save")
    public String saveFood(@ModelAttribute Food food,
                           @RequestParam("image") MultipartFile file,
                           RedirectAttributes redirectAttributes) {

        if (file.isEmpty() || food.getPrice() < 0) {
            redirectAttributes.addFlashAttribute("error", "Dữ liệu không hợp lệ!");
            return "redirect:/food/add";
        }

        try {
            // 1. Logic sinh tên file duy nhất bằng UUID
            String extension = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID() + "_" + System.currentTimeMillis() + extension;

            File dest = new File("C:/RikkeiFood_Temp/" + uniqueFileName);
            if (!dest.getParentFile().exists()) dest.getParentFile().mkdirs();

            // Lưu file
            file.transferTo(dest);

            // 2. Cập nhật đối tượng Food và lưu vào List tĩnh
            food.setImageUrl(dest.getAbsolutePath());
            foodList.add(food);

            // 3. Quản lý luồng: Dùng RedirectAttributes truyền thông báo và thông tin
            redirectAttributes.addFlashAttribute("message", "Thêm món ăn thành công!");
            redirectAttributes.addFlashAttribute("newFood", food);

            // In console xác nhận theo yêu cầu
            System.out.println("Đã thêm: " + food.getName() + " | Tổng số: " + foodList.size());

            return "redirect:/food/detail?id=" + (foodList.size() - 1);

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Lỗi lưu file: " + e.getMessage());
            return "redirect:/food/add";
        }
    }

    // Handler hiển thị trang chi tiết
    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {
        if (id >= 0 && id < foodList.size()) {
            model.addAttribute("food", foodList.get(id));
            return "food-detail";
        }
        return "redirect:/food/add";
    }
}