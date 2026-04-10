package atmin.b3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    private final ServletContext application;

    public OrderController(ServletContext application) {
        this.application = application;
    }

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model) {
        // Kiểm tra bảo mật: Nếu chưa login thì không cho xem đơn hàng
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // Xử lý Race Condition cho APPLICATION SCOPE
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            application.setAttribute("totalViewCount", count + 1);
        }

        // Tạo dữ liệu giả (Hardcode)
        List<Order> orders = Arrays.asList(
                new Order("ORD001", "Laptop Dell", 15000000.0, new Date()),
                new Order("ORD002", "iPhone 15 Pro", 28500000.0, new Date()),
                new Order("ORD003", "Bàn phím cơ AKKO", 1550000.0, new Date()),
                new Order("ORD004", "Chuột Logitech G502", 950000.0, new Date())
        );

        // Đẩy vào Request Scope để JSP hiển thị
        model.addAttribute("orders", orders);
        return "orders";
    }
}