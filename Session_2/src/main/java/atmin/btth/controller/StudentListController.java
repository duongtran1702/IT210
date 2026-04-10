package atmin.btth.controller;

import atmin.btth.model.entity.Student;
import atmin.btth.model.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentListController {
    private final StudentService studentService;

    public StudentListController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("listStudent", students);
        return "test";
    }
}

