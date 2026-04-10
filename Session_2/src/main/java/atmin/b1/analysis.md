# Phân tích Logic Cấu hình Spring MVC

## 1. Lỗi trong MyWebAppInitializer.java

*   **Nguyên nhân gây lỗi 404:** Trong phương thức `getServletMappings()`, giá trị trả về là `"/api/*"`. Điều này chỉ định rằng **DispatcherServlet** (bộ điều phối trung tâm của Spring) chỉ chịu trách nhiệm xử lý các yêu cầu (requests) có tiền tố đường dẫn bắt đầu bằng `/api/`.
*   **Phạm vi lắng nghe:** Với cấu hình hiện tại, DispatcherServlet chỉ lắng nghe các URL như `/api/users`, `/api/products`,... Trong khi đó, yêu cầu `/welcome` không khớp với mẫu (pattern) này. Do đó, request sẽ không bao giờ đến được Spring MVC mà bị chặn lại hoặc trả về lỗi **404 Not Found** bởi Servlet Container (như Tomcat).

## 2. Lỗi trong WebConfig.java

*   **Hậu quả:** Annotation `@ComponentScan(basePackages = "com.demo.service")` giới hạn phạm vi tìm kiếm các Bean của Spring chỉ nằm trong package `service`.
*   **Vấn đề tìm kiếm Controller:** Trong kiến trúc Spring MVC, các lớp xử lý request phải được đánh dấu bằng `@Controller`. Lớp `WelcomeController` hiện đang nằm trong package `com.demo.controller`. Vì cấu hình quét component bị sai địa chỉ, Spring Container sẽ **không tìm thấy** và không khởi tạo Controller này.

## 3. Tổng hợp và Đánh giá

*   **Câu hỏi:** Nếu chỉ sửa lỗi 1 (Servlet Mapping) mà không sửa lỗi 2 (ComponentScan), ứng dụng có chạy không?
*   **Trả lời:** **KHÔNG.**
*   **Giải thích:**
    *   Mặc dù lỗi 1 được sửa giúp DispatcherServlet "nhìn thấy" request `/welcome`.
    *   Tuy nhiên, khi request đi vào trong, DispatcherServlet sẽ tra cứu danh sách các Controller đã được đăng ký để xử lý.
    *   Do lỗi 2 chưa được sửa, `WelcomeController` không hề tồn tại trong bộ nhớ của Spring (ApplicationContext).
    *   Kết quả là Spring sẽ báo lỗi không tìm thấy Handler (Handler Mapping Not Found) và người dùng vẫn nhận được thông báo lỗi 404.