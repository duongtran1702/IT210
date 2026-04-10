package atmin.btth.controller;

import atmin.btth.model.entity.Student;
import atmin.btth.model.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentDetailController {
    private final StudentService studentService;

    public StudentDetailController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Cách 1: RESTful path variable - http://localhost:8080/Session2/students/SV001
    @GetMapping("/students/{studentId}")
    public String getStudentById(@PathVariable String studentId, Model model) {
        Student student = studentService.getAllStudents().stream()
                .filter(s -> s.id.equals(studentId))
                .findFirst().orElse(null);
        model.addAttribute("listStudent", student);
        return "studentcard";
    }

    // Cách 2: Query parameter (cách cũ) - http://localhost:8080/Session2/id?id=SV001
    @GetMapping("/id")
    public String studentCard(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập ID sinh viên");
            return "studentcard";
        }
        
        Student temp = studentService.getAllStudents().stream()
                .filter(student -> student.id.equals(id))
                .findFirst().orElse(null);
        model.addAttribute("listStudent", temp);
        return "studentcard";
    }
}

