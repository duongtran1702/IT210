package atmin.b3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    private static final List<Food> foodList = new ArrayList<>();
    private static final String UPLOAD_PATH = "C:/RikkeiFood_Temp/";

    @GetMapping("/add")
    public String showForm() {
        return "add-food"; // Trả về view form thêm món ăn
    }

    @PostMapping("/save")
    public String saveFood(@RequestParam("name") String name,
                           @RequestParam("category") String category,
                           @RequestParam("price") double price,
                           @RequestParam("image") MultipartFile file,
                           Model model) {

        // 1. Bẫy dữ liệu: Quên đính kèm ảnh
        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh minh họa!");
            return "add-food";
        }

        // 2. Bẫy dữ liệu: Sai định dạng file
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            model.addAttribute("error", "Chỉ chấp nhận định dạng ảnh (jpg, png, jpeg)!");
            return "add-food";
        }

        // 3. Bẫy dữ liệu: Giá tiền âm
        if (price < 0) {
            model.addAttribute("error", "Giá tiền không được nhỏ hơn 0!");
            return "add-food";
        }

        try {
            // Tạo thư mục nếu chưa tồn tại
            File uploadDir = new File(UPLOAD_PATH);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // Lưu file vào server vật lý
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File dest = new File(UPLOAD_PATH + fileName);
            file.transferTo(dest);

            // Thêm vào List tĩnh
            Food newFood = new Food(name, category, price, "/images/" + fileName);
            foodList.add(newFood);

            // Xác nhận ra console
            System.out.println("=== THÊM MÓN ĂN THÀNH CÔNG ===");
            System.out.println("Tên: " + newFood.getName());
            System.out.println("Danh mục: " + newFood.getCategory());
            System.out.println("Giá: " + newFood.getPrice());
            System.out.println("Đường dẫn ảnh: " + newFood.getImageUrl());
            System.out.println("Tổng số món trong danh sách: " + foodList.size());
            System.out.println("==============================");

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi lưu file: " + e.getMessage());
            return "add-food";
        }

        return "redirect:/food/list";
    }
}