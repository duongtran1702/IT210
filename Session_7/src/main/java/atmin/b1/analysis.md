## Phần 1: Phân tích nguyên nhân lỗi

### 1. Tại sao "Tên cửa hàng" bị null?

* **Nguyên nhân:** Trong Spring MVC, để tự động bind dữ liệu vào Object, thuộc tính `name` của thẻ `<input>` trong HTML **phải trùng khớp hoàn toàn** với tên thuộc tính (field) trong Class Model.
* **Lỗi cụ thể:** * Trong Model class: Thuộc tính là `name`.
    * Trong HTML: Thuộc tính `name="restaurantName"`.
* **Kết quả:** Spring tìm trong Model không thấy trường nào là `restaurantName` nên nó bỏ qua, còn trường `name` trong Model không nhận được dữ liệu nên mặc định là `null`.

### 2. Tại sao ô Checkbox `active` bị lỗi logic?

* **Nguyên nhân:** Kiểu dữ liệu `boolean` trong Java mong đợi các giá trị như `"true"/"false"`, `"on"/"off"`, hoặc `"1"/"0"`.
* **Lỗi cụ thể:** Thẻ HTML đang để `value="MỞ_CỬA"`.
* **Kết quả:** Khi chủ quán tích chọn, trình duyệt gửi chuỗi `"MỞ_CỬA"` về Backend. Spring không thể ép kiểu (parse) chuỗi này sang kiểu `boolean` (true/false) của trường `active`, dẫn đến lỗi Type Mismatch hoặc logic sai lệch.