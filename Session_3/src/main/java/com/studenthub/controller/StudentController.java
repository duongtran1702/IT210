
package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "faculty", required = false) String faculty,
            @RequestParam(name = "sortBy", required = false) String sortBy,
            Model model
    ) {
        List<Student> students = studentService.getStudents(search, faculty, sortBy);

        model.addAttribute("students", students);
        model.addAttribute("resultCount", students.size());
        model.addAttribute("search", search == null ? "" : search);
        model.addAttribute("faculty", faculty == null ? "" : faculty);
        model.addAttribute("sortBy", sortBy == null ? "" : sortBy);

        return "students/list";
    }

    @GetMapping("/detail")
    public String studentDetail(@RequestParam(name = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            model.addAttribute("errorMessage", "Khong tim thay sinh vien voi id = " + id);
            return "students/not-found";
        }

        model.addAttribute("student", student);
        return "students/detail";
    }
}
