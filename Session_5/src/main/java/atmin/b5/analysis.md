# BÁO CÁO BÀI TẬP 5: THIẾT KẾ HỆ THỐNG QUẢN LÝ ĐƠN HÀNG (DISH DETAIL)

## 1. Kiến trúc hệ thống (Data Flow 3 tầng)
Hệ thống được thiết kế theo mô hình 3 lớp tiêu chuẩn để đảm bảo tính tách biệt của các thành phần (Separation of Concerns):

* **OrderController:** Tiếp nhận yêu cầu từ URL `/bai5/detail/{id}`, điều phối dữ liệu và chọn View hiển thị.
* **OrderService:** Chứa logic nghiệp vụ (Business Logic). Mọi tính toán hoặc kiểm tra điều kiện đều nằm ở đây để đảm bảo View "ngu ngốc" (Dumb View).
* **OrderRepository:** Quản lý dữ liệu. Sử dụng danh sách in-memory để giả lập cơ sở dữ liệu.
---