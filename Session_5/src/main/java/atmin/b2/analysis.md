## Yêu cầu & Đầu ra

### I. Báo cáo phân tích

Đối tượng Dish gồm:
- id, name, price, isAvailable

Luồng xử lý:
- Client gửi request: /bai2/dish-list
- Controller nhận request → gọi Service
- Service trả về List<Dish>
- Controller đưa vào Model
- View (dish-list.html) hiển thị

Xử lý View:
- th:each để lặp danh sách
- th:if / th:unless để hiển thị "Còn hàng" / "Hết hàng"

Bẫy dữ liệu:
- Nếu danh sách null hoặc empty → hiển thị:
  "Hiện tại nhà hàng đang cập nhật thực đơn, vui lòng quay lại sau"

---
