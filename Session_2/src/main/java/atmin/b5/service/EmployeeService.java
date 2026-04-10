package atmin.b5.service;

import atmin.b5.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        // Dữ liệu mẫu
        employees.add(new Employee("NV001", "Nguyễn Thị Lan", "lan@company.com", "Kế toán", 15000000, LocalDate.of(2020, 3, 1), "Đang làm"));
        employees.add(new Employee("NV002", "Trần Văn Hùng", "hung@company.com", "Kỹ thuật", 25000000, LocalDate.of(2019, 7, 15), "Đang làm"));
        employees.add(new Employee("NV003", "Phạm Minh Tú", "tu@company.com", "Kỹ thuật", 20000000, LocalDate.of(2021, 1, 10), "Đang làm"));
        employees.add(new Employee("NV004", "Lê Thanh Hoa", "hoa@company.com", "Nhân sự", 12000000, LocalDate.of(2020, 6, 15), "Nghỉ phép"));
        employees.add(new Employee("NV005", "Đỗ Quang Hải", "hai@company.com", "Kỹ thuật", 18000000, LocalDate.of(2022, 9, 1), "Đang làm"));
    }

    // Lấy danh sách tất cả nhân viên
    public List<Employee> getAll() {
        return employees;
    }

    // Tìm nhân viên theo mã
    public Employee getByCode(String code) {
        return employees.stream()
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    // Thêm nhân viên
    public void add(Employee employee) {
        employees.add(employee);
    }

    // Cập nhật thông tin nhân viên
    public void update(Employee employee) {
        employees.stream()
                .filter(e -> e.getCode().equals(employee.getCode()))
                .findFirst()
                .ifPresent(e -> {
                    e.setFullName(employee.getFullName());
                    e.setEmail(employee.getEmail());
                    e.setDepartment(employee.getDepartment());
                    e.setSalary(employee.getSalary());
                    e.setJoinDate(employee.getJoinDate());
                    e.setStatus(employee.getStatus());
                });
    }

    // Xóa nhân viên
    public void delete(String code) {
        employees.removeIf(e -> e.getCode().equals(code));
    }
}