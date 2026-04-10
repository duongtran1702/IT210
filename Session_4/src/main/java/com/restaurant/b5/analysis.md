# BÁO CÁO PHÂN TÍCH TÍNH IDEMPOTENT TRONG QUẢN LÝ ĐƠN HÀNG

## 1. Phân tích Route Hủy đơn hàng (DELETE)
- **Tính chất:** Phương thức DELETE trong chuẩn RESTful có tính **Idempotent**.
- **Lập luận:** Khi nhân viên bấm nút "Hủy đơn" 3 lần liên tục do lag mạng:
    - Lần 1: Hệ thống tìm đơn hàng và xóa nó (Dữ liệu bị thay đổi).
    - Lần 2 & 3: Hệ thống cố gắng xóa đơn hàng đó nhưng nó không còn tồn tại nữa. Kết quả cuối cùng vẫn là "Đơn hàng đó đã biến mất".
- **Kết luận:** Dù bấm nhiều lần, kết quả cuối cùng trên cơ sở dữ liệu không đổi, do đó nó AN TOÀN và không làm hỏng dữ liệu.

## 2. Phân tích Route Tạo đơn hàng (POST)
- **Tính chất:** Phương thức POST **KHÔNG** có tính Idempotent.
- **Lập luận:** Khi nhân viên bấm nút "Lưu Đơn" 3 lần liên tục do tưởng máy đơ:
    - Mỗi lần bấm, trình duyệt gửi một yêu cầu tạo tài nguyên mới hoàn toàn.
    - Hệ thống sẽ tạo ra 3 bản ghi đơn hàng khác nhau trong cơ sở dữ liệu (dù nội dung giống hệt nhau).
- **Kết luận:** Việc bấm liên tục gây rủi ro sinh ra "đơn hàng rác", gây thất thoát hoặc nhầm lẫn trong khâu chế biến của nhà hàng.

## 3. Giải pháp thực tế (Mở rộng)
Để khắc phục vấn đề của POST, chúng ta có thể:
1. Disable nút bấm ở phía Giao diện (Frontend) ngay sau khi nhấn lần đầu.
2. Sử dụng Idempotency Key (Token) ở Backend để nhận diện và từ chối các yêu cầu trùng lặp trong khoảng thời gian ngắn.