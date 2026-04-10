package atmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping("/view-form")
    public String viewForm() {
        return "upload";
    }

    @PostMapping("/process")
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) {
        String path = "D:\\IT210\\Session_7\\src\\main\\webapp\\images\\";

        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn file!");
            return "upload";
        }

        try {
            String fileName = file.getOriginalFilename();
            File destination = new File(path + fileName);
            file.transferTo(destination);
            model.addAttribute("imgName", fileName);
            return "result";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi: " + e.getMessage());
            return "upload";
        }
    }
}