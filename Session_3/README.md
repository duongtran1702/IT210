# PHÂN CÔNG NHIỆM VỤ DỰ ÁN: STUDENTHUB (CẤU TRÚC MỚI)

## 1. Tổng quan dự án
- **Nhóm:** 10 thành viên.
- **Kiến trúc:** Spring MVC thuần, 4 tầng (Model - Repo - Service - Controller).
- **Yêu cầu đặc biệt:** Dữ liệu khởi tạo (Hardcoded) gồm 10 thành viên trong nhóm.

## 2. Bảng phân công chi tiết

| STT | Thành viên | Vai trò | Nhiệm vụ chi tiết | File đảm nhiệm chính |
|:---:|:---|:---|:---|:---|
| 01 |  **Toàn**  | Cấu hình (Config) | Thiết lập Java Config cho Spring MVC, ViewResolver và quản lý vòng đời ứng dụng. | `AppConfig.java`, `WebInit.java` |
| 02 |  **Bách**  | Model Core | Định nghĩa Enum `StudentStatus` và class `Student` với đầy đủ các field theo SRS. | `Student.java`, `StudentStatus.java` |
| 03 |  **Quang** | Model Báo cáo | Thiết kế class `DashboardSummary` để chứa các dữ liệu thống kê (Tỉ lệ, Thủ khoa, GPA TB). | `DashboardSummary.java` |
| 04 |   **Huy**  | Repository Base | Viết Interface `StudentRepository` và định nghĩa các phương thức truy xuất dữ liệu cơ bản. | `StudentRepository.java` |
| 05 |  **Phong** | Data Seeding | Implement `StudentRepositoryImpl`, khởi tạo danh sách 10 thành viên nhóm (Hardcoded data). | `StudentRepositoryImpl.java` |
| 06 |  **Minh**  | Service Logic 1 | Xử lý logic tìm kiếm, lọc theo khoa và sắp xếp (Sort) tại tầng Service. | `StudentService.java` (phần Filter/Sort) |
| 07 |  **Hoàng** | Service Logic 2 | Xử lý logic tính toán thống kê và đóng gói vào đối tượng `DashboardSummary`. | `StudentService.java` (phần Stats) |
| 08 |  **Dương** | Controller | Viết bộ điều hướng cho danh sách sinh viên, chi tiết sinh viên và dashboard. | `StudentController.java`, `DashboardController.java` |
| 09 |  **Thành** | Frontend (Student) | Xây dựng giao diện danh sách và chi tiết (sử dụng JSTL/EL để hiển thị dynamic data). | `students/list.jsp`, `students/detail.jsp` |
| 10 |  **Nhật**  | Frontend (Admin) | Thiết kế giao diện Dashboard và viết CSS/JS dùng chung cho toàn bộ hệ thống. | `dashboard.jsp`, `resources/css/`, `js/` |
## 3. Cấu trúc thư mục thống nhất
```text
src/
├── main/
│   ├── java/
│   │   └── com/studenthub/
│   │       ├── config/
│   │       │   ├── AppConfig.java
│   │       │   └── WebInit.java
│   │       │
│   │       ├── controller/
│   │       │   ├── StudentController.java
│   │       │   └── DashboardController.java
│   │       │
│   │       ├── service/
│   │       │   └── StudentService.java
│   │       │
│   │       ├── repository/
│   │       │   ├── StudentRepository.java
│   │       │   └── impl/
│   │       │       └── StudentRepositoryImpl.java
│   │       │
│   │       └── model/
│   │           ├── DashboardSummary.java
│   │           ├── StudentStatus.java
│   │           └── Student.java
│   │
│   ├── webapp/
│   │   ├── WEB-INF/
│   │   │   ├── views/
│   │   │   │   ├── students
│   │   │   │   │   ├── detail.jsp
│   │   │   │   │   ├── list.jsp
│   │   │   │   └── dashboard.jsp
│   │   │   │
│   │   │   └── web.xml (optional)
│   │   │
│   │   └── resources/
│   │       ├── css/
│   │       └── js/
