# 1. BẢN THIẾT KẾ I/O (DATA FLOW) - BÀI 4

## 1.1. Sơ đồ luồng dữ liệu (Data Flow Diagram)
Dữ liệu di chuyển theo mô hình tuyến tính từ Client đến giao diện hiển thị:

**URL Parameters** (?category=...&limit=...) → **Controller** (@RequestParam) → **ModelMap** (cate, lim, msg) → **File View** (productList.jsp)

---

## 1.2. Chi tiết các thành phần I/O

| Thành phần              | Tên tham số / Key | Kiểu dữ liệu | Mô tả                                                |
|:------------------------|:------------------|:-------------|:-----------------------------------------------------|
| **Dữ liệu vào (Input)** | `category`        | `String`     | Lấy từ tham số trên URL (`?category=...`)            |
| **Dữ liệu vào (Input)** | `limit`           | `int`        | Lấy từ tham số trên URL (`&limit=...`)               |
| **Xử lý (Controller)**  | `ModelMap`        | `Object`     | Đối tượng trung chuyển dữ liệu từ Controller ra View |
| **Key trong ModelMap**  | `cate`            | `String`     | Map từ biến `category` để hiển thị trên JSP          |
| **Key trong ModelMap**  | `lim`             | `int`        | Map từ biến `limit` để hiển thị trên JSP             |
| **Key trong ModelMap**  | `msg`             | `String`     | Chuỗi thông báo tự tạo (VD: "Tìm kiếm thành công")   |
| **Dữ liệu ra (Output)** | `productList.jsp` | `View`       | Trang giao diện hiển thị kết quả cuối cùng cho khách |

---

## 1.3. Mô tả chi tiết luồng đi (Data Path)

1. **Tiếp nhận:** Người dùng gửi yêu cầu qua URL kèm theo các tham số truy vấn (Query Parameters).
2. **Xử lý:** Controller nhận dữ liệu thông qua `@RequestParam`. Tại đây, lập trình viên sử dụng tính năng **Method Chaining** của `ModelMap` để đẩy dữ liệu ra View với các Key tương ứng (`cate`, `lim`, `msg`).
3. **Phân giải View:** Controller trả về chuỗi `"productList"`. Spring View Resolver sẽ tìm file vật lý tại `/WEB-INF/views/productList.jsp`.
4. **Hiển thị:** File JSP sử dụng Expression Language (ví dụ: `${cate}`) để truy xuất dữ liệu từ ModelMap và render thành mã HTML trả về cho trình duyệt.