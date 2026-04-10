# BÁO CÁO PHÂN TÍCH BẢO MẬT VÀ KỸ THUẬT JSTL

## 1. Lỗ hổng XSS và Cơ chế Phòng vệ của `<c:out>`

### 1.1. XSS (Cross-Site Scripting) là gì?
XSS là một lỗ hổng bảo mật cho phép kẻ tấn công chèn các đoạn mã kịch bản độc hại (thường là JavaScript) vào trang web. Khi người dùng khác truy cập và xem trang này, trình duyệt của họ sẽ vô tình thực thi đoạn mã đó, dẫn đến nguy cơ bị đánh cắp Session Cookie, chiếm quyền điều khiển tài khoản hoặc thay đổi giao diện trang web trái phép.

### 1.2. So sánh `${keyword}` và `<c:out>`
Giả sử người dùng nhập từ khóa tìm kiếm là: `<script>alert(1)</script>`

| Phương pháp              | Output HTML thực tế                     | Kết quả trên trình duyệt                                               |
|:-------------------------|:----------------------------------------|:-----------------------------------------------------------------------|
| **Sử dụng `${keyword}`** | `<script>alert(1)</script>`             | Trình duyệt thực thi script và hiện thông báo Popup (Bị tấn công XSS). |
| **Sử dụng `<c:out>`**    | `&lt;script&gt;alert(1)&lt;/script&gt;` | Trình duyệt hiển thị chuỗi văn bản thuần túy (An toàn).                |

**Kết luận:** Thẻ `<c:out>` an toàn hơn vì nó mặc định thực hiện **HTML Escaping**. Các ký tự đặc biệt được chuyển thành các thực thể HTML, khiến trình duyệt chỉ hiển thị chúng như văn bản thay vì thực thi như mã lệnh.

---

## 2. Phân biệt `<c:if>` và `<c:choose>` trong Logic Hiển thị

### 2.1. Đặc điểm kỹ thuật
*   **`<c:if>`**: Dùng cho các điều kiện đơn lẻ (nếu đúng thì thực hiện). Nó không có nhánh `else` hoặc `else if`.
*   **`<c:choose>`**: Hoạt động tương tự cấu trúc `switch-case` hoặc `if-else if-else`. Nó bao gồm các thẻ con `<c:when>` (các trường hợp cụ thể) và `<c:otherwise>` (trường hợp mặc định).

### 2.2. Áp dụng cho "Giá vé" và "Vé còn lại"
Trong bài toán này, nên sử dụng **`<c:choose>`** vì:
*   **Tính loại trừ:** Một vé chỉ có thể rơi vào một trạng thái duy nhất (ví dụ: hoặc là "MIỄN PHÍ", hoặc là "CÓ PHÍ"). `<c:choose>` đảm bảo chỉ có duy nhất một khối lệnh được render ra HTML.
*   **Sạch mã nguồn:** Tránh việc phải lặp lại nhiều thẻ `<c:if>` với các điều kiện phủ định lẫn nhau, giúp trang JSP dễ đọc và dễ bảo trì hơn.

---

## 3. Tầm quan trọng của thẻ `<c:url>`

### 3.1. Vấn đề Context Path
Khi ứng dụng được triển khai (deploy), đường dẫn gốc (Context Path) có thể thay đổi tùy theo cấu hình máy chủ (ví dụ: `/` hoặc `/ticketing`).
*   Nếu dùng link cố định (hardcode): `<a href="/events/1/book">` -> Link sẽ bị sai (lỗi 404) nếu ứng dụng chạy dưới context `/ticketing`.

### 3.2. Giải pháp từ `<c:url>`
Thẻ `<c:url>` giải quyết triệt để vấn đề này thông qua hai cơ chế:
1.  **Tự động chèn Context Path:** Nó tự động nhận diện và thêm tiền tố context hiện tại vào trước đường dẫn (Ví dụ: `/ticketing/events/1/book`).
2.  **Hỗ trợ Session Tracking:** Nếu trình duyệt người dùng tắt Cookie, thẻ này sẽ thực hiện **URL Rewriting** bằng cách đính kèm `;jsessionid=...` vào URL để duy trì phiên làm việc (Session) mà không bị gián đoạn.

---

## 4. Quy tắc Triển khai An toàn
*   **Không dùng Scriptlet**: Tuyệt đối không viết code Java `<% ... %>` trong JSP.
*   **Mã hóa đầu ra**: Tất cả dữ liệu do người dùng nhập vào phải đi qua `<c:out>` trước khi hiển thị.
*   **Tách biệt CSS**: Sử dụng class CSS thay cho các thuộc tính hiển thị lỗi thời (obsolete attributes) như `border`, `cellpadding`.