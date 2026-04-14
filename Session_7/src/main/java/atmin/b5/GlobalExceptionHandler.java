package atmin.b5;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleFileUploadError(Exception ex, Model model) {
        if (ex.getMessage() != null && ex.getMessage().contains("exceeds maximum size")) {
            model.addAttribute("error", "File quá lớn! Dung lượng banner tối đa là 10MB.");
            return "error-page"; // Trả về view báo lỗi
        }
        model.addAttribute("error", "Có lỗi xảy ra: " + ex.getMessage());
        return "error-page";
    }
}