package atmin.b5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/combo")
public class ComboController {
    private static final List<Combo> comboList = new ArrayList<>();

    @PostMapping("/save")
    public String saveCombo(@ModelAttribute Combo combo,
                            @RequestParam("banner") MultipartFile file,
                            Model model) {

        // Bẫy dữ liệu: Số lượng món ít nhất 2
        if (combo.getItemList() == null || combo.getItemList().size() < 2) {
            model.addAttribute("error", "Combo phải có ít nhất 2 món!");
            return "add-combo";
        }

        try {
            // Xử lý lưu file (tương tự bài trước dùng UUID)
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            File dest = new File("C:/RikkeiFood_Temp/" + fileName);
            file.transferTo(dest);
            combo.setBannerUrl(dest.getAbsolutePath());

            // Lưu vào list tĩnh
            comboList.add(combo);

            // In kết quả ra console dạng JSON (Dùng thư viện Jackson hoặc in thủ công)
            System.out.println("=== NEW COMBO ADDED ===");
            System.out.println("{");
            System.out.println("  \"comboName\": \"" + combo.getComboName() + "\",");
            System.out.println("  \"items\": " + combo.getItemList().toString() + ",");
            System.out.println("  \"banner\": \"" + combo.getBannerUrl() + "\"");
            System.out.println("}");

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi lưu file banner.");
            return "add-combo";
        }

        return "redirect:/combo/success";
    }
}