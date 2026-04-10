package atmin.controller;

import atmin.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import static atmin.model.Gender.*;

@Controller
@RequestMapping
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1L, "Atmin", 20, MALE),
            new Student(2L, "Mynato", 20, MALE),
            new Student(3L, "Alice", 20, FEMALE)
    ));

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", students);
        return "home";
    }

    @GetMapping("/add-student")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/add-student")
    public String addStudent(Student student, RedirectAttributes redirectAttributes) {
        if (student.getId() == null) {
            long maxId = students.stream().mapToLong(Student::getId).max().orElse(0L);
            student.setId(maxId + 1);
        }

        boolean exists = students.stream().anyMatch(s -> s.getId().equals(student.getId()));

        if (exists) {
            students.removeIf(s -> s.getId().equals(student.getId()));
        }

        students.add(student);
        redirectAttributes.addFlashAttribute("message", "Lưu dữ liệu thành công!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable("id") long stuId) {
        Student temp = students.stream().filter(s -> s.getId() == stuId).findFirst().orElse(null);
        model.addAttribute("student", temp);
        return "form";
    }
}
