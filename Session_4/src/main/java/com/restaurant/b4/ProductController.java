package com.restaurant.b4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/bai4/products")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") int limit,
            ModelMap model) {

        // Viết 1 dòng duy nhất sử dụng Method Chaining
        model.addAttribute("cate", category).addAttribute("lim", limit).addAttribute("msg", "Tìm kiếm thành công!");

        return "productList"; // Trả về tên file JSP (productList.jsp)
    }
}