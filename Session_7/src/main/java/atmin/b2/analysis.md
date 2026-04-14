# Phân tích Logic & Tối ưu Controller

## 1. Lỗi thiết kế: Vi phạm nguyên tắc DRY (Don't Repeat Yourself)
Trong code cũ, đoạn khởi tạo danh sách `categories` và đẩy vào `Model` bị lặp lại tại cả 3 phương thức xử lý (`/add`, `/edit`, `/search`).

**Rủi ro bảo trì:**
* **Khó chỉnh sửa:** Khi cần thêm/bớt danh mục, phải sửa ở nhiều nơi. Thiếu sót sẽ gây bất đồng bộ dữ liệu.
* **Code rác:** Controller bị phình to bởi các logic lặp lại, gây khó khăn cho việc đọc hiểu luồng chính.

---