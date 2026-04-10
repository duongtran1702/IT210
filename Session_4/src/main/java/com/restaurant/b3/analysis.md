# PHÂN TÍCH THIẾT KẾ URL TRONG SPRING MVC

## 1. Phân tích theo ý hiểu

### Vị trí của số 5 trong URL:

*   **Cách A (`/bai3/orders/5`)**:
    *   Số 5 đóng vai trò là một **biến đường dẫn (Path Segment)**.
    *   Nó là một phần trực tiếp cấu thành nên địa chỉ URL, đại diện cho định danh chính xác của tài nguyên.
*   **Cách B (`/bai3/orders?id=5`)**:
    *   Số 5 là giá trị của một **tham số truy vấn (Query Parameter)**.
    *   Nó nằm sau dấu `?` và mang tính chất bổ trợ thông tin, không thay đổi cấu trúc định danh gốc của đường dẫn.

---

## 2. Lựa chọn phương pháp phù hợp

Để lấy ID của một đối tượng cụ thể (như xem thông tin chi tiết của một đơn hàng), **Cách A phù hợp hơn** và là tiêu chuẩn trong thiết kế RESTful API hiện đại.

### Lý do chọn Cách A:

1.  **Tính phân cấp:** Giúp URL sạch sẽ, dễ đọc và thể hiện rõ mối quan hệ phân cấp (Đối tượng cha -> ID đối tượng con).
2.  **Chuẩn Semantic Web:** Mỗi tài nguyên (đơn hàng số 5) nên có một địa chỉ định danh duy nhất và cố định.
3.  **Phân biệt mục đích:**
    *   **Cách A** dùng để **Định danh** (xác định duy nhất 1 đối tượng).
    *   **Cách B** dùng để **Điều hướng dữ liệu** (lọc, sắp xếp hoặc tìm kiếm trong một danh sách nhiều đối tượng).

---