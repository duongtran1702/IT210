# BÁO CÁO BÀI TẬP: QUẢN LÝ LAYOUT VỚI THYMELEAF

## 1. So sánh các phương pháp quản lý Layout

| Tiêu chí             | (A) Copy-paste Header/Footer                                                  | (B) Sử dụng layout:decorate                                          |
|:---------------------|:------------------------------------------------------------------------------|:---------------------------------------------------------------------|
| **Cơ chế**           | Chép thủ công đoạn code Header/Footer vào mỗi file HTML mới.                  | Định nghĩa một khung xương chung, các trang con chỉ việc kế thừa.    |
| **Tốc độ ban đầu**   | Nhanh, không cần cài đặt thêm thư viện.                                       | Cần thời gian cấu hình ban đầu cho Layout Dialect.                   |
| **Tính bảo trì**     | **Rất kém.** Muốn đổi một mục trên Menu phải sửa tất cả các file trong dự án. | **Rất tốt.** Chỉ cần sửa một lần duy nhất tại file layout gốc.       |
| **Độ sạch của mã**   | Thấp. Code bị lặp lại quá nhiều (vi phạm nguyên lý DRY).                      | Cao. Các file con cực kỳ gọn gàng, chỉ tập trung vào nội dung riêng. |
| **Khả năng mở rộng** | Khó khăn khi số lượng trang tăng lên (dễ xảy ra sai sót, không đồng bộ).      | Dễ dàng. Dự án có hàng trăm trang vẫn đảm bảo giao diện thống nhất.  |

---

## 2. Triển khai Layout theo Cách B

### a. File Layout chính: layout.html
*Vị trí: src/main/resources/templates/common/layout.html*
---

## 3. Phân tích kỹ thuật

**Tại sao phải đăng ký Bean LayoutDialect trong cấu hình Java?**

Mặc dù chúng ta đã thêm Namespace xmlns:layout vào file HTML, việc đăng ký Bean LayoutDialect trong mã nguồn Java vẫn là bắt buộc vì những lý do sau:

1. **Mở rộng khả năng của Template Engine:** Mặc định, Thymeleaf Engine chỉ hiểu các thuộc tính lõi bắt đầu bằng th:. LayoutDialect là một thư viện bổ trợ (extension). Việc đăng ký Bean giúp tích hợp logic xử lý của thư viện này vào quy trình render của Spring Boot.
2. **Kích hoạt tính năng "Kế thừa" (Decorate):** Nếu không có Bean này, các thuộc tính như layout:decorate và layout:fragment sẽ bị coi là các attribute HTML không hợp lệ và bị bỏ qua. Kết quả là trang web sẽ không hiển thị được Header/Footer dùng chung.
3. **Cơ chế hoạt động của Spring:** Đăng ký dưới dạng một Bean giúp Spring Boot tự động kết nối (wiring) Dialect này với SpringTemplateEngine. Điều này đảm bảo các biến Model, PathVariables và các tiện ích của Spring MVC hoạt động xuyên suốt từ trang cha đến trang con.