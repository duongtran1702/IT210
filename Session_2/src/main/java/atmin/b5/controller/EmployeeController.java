package atmin.b5.controller;


import atmin.b5.model.Employee;
import atmin.b5.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // 1. Khai báo final để đảm bảo bất biến
    private final EmployeeService employeeService;

    // 2. Tiêm phụ thuộc qua Constructor (Spring sẽ tự hiểu và nạp EmployeeService vào đây)
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> list = employeeService.getAll();
        model.addAttribute("employees", list);

        // Tính tổng lương phòng Kỹ thuật (Business logic thực hiện tại đây hoặc Service)
        long techSalary = list.stream()
                .filter(e -> "Kỹ thuật".equals(e.getDepartment()))
                .mapToLong(Employee::getSalary)
                .sum();
        model.addAttribute("techSalary", techSalary);

        return "list";
    }

    @GetMapping("/{code}")
    public String detail(@PathVariable String code, Model model) {
        Employee emp = employeeService.getByCode(code);

        // Ném ngoại lệ nếu không tìm thấy để GlobalExceptionHandler xử lý (Ràng buộc 3.4)
        if (emp == null) {
            throw new RuntimeException("Nhân viên [" + code + "] không tồn tại trong hệ thống");
        }

        model.addAttribute("employee", emp);
        return "detail";
    }
}