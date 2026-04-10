## Phân tích

Lỗi 1: Sai thư mục chứa template  
resolver.setPrefix("/WEB-INF/views");
- Chuẩn Thymeleaf: /WEB-INF/templates/
- /views dùng cho JSP

Lỗi 2: Sai định dạng file template  
resolver.setSuffix(".jsp");
- Thymeleaf dùng .html
- Không hỗ trợ .jsp

Lỗi 3: Trộn lẫn JSP và Thymeleaf
- Dùng .jsp (JSP) với SpringResourceTemplateResolver (Thymeleaf)
- Hai công nghệ khác nhau, không dùng chung
