package atmin.theory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private static final String UPLOAD_PATH = "D:\\IT210\\Session_7\\src\\main\\webapp\\images\\";

    @GetMapping("/view-form")
    public String viewForm() {
        return "upload";
    }

    @PostMapping("/process")
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn file!");
            return "upload";
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.trim().isEmpty()) {
            model.addAttribute("error", "Tên file không hợp lệ");
            return "upload";
        }

        try {
            File destination = new File(UPLOAD_PATH + fileName);
            File dir = destination.getParentFile();

            if (dir != null && !dir.exists() && !dir.mkdirs()) {
                throw new IOException("Không thể tạo thư mục");
            }

            file.transferTo(destination);
            model.addAttribute("imgName", fileName);
            return "result";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi: " + e.getMessage());
            return "upload";
        }
    }
}