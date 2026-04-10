package atmin.b5.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Employee {
    private String code;           // Mã NV
    private String fullName;       // Họ tên
    private String email;          // Email
    private String department;     // Phòng ban
    private long salary;           // Lương (VNĐ)
    private LocalDate joinDate;    // Ngày vào làm
    private String status;         // Trạng thái

    // Constructor không tham số
    public Employee() {
    }

    // Constructor đầy đủ
    public Employee(String code, String fullName, String email, String department,
                    long salary, LocalDate joinDate, String status) {
        this.code = code;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    // Getters và Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public long getSalary() { return salary; }
    public void setSalary(long salary) { this.salary = salary; }

    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }

    // Getter để sử dụng với fmt:formatDate (chuyển LocalDate → java.util.Date)
    public Date getJoinDateAsDate() {
        if (joinDate == null) return null;
        return Date.from(joinDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}