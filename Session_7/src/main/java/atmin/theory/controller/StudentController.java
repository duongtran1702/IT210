package atmin.theory.controller;

import atmin.theory.dto.StudentDTO;
import atmin.theory.model.Gender;
import atmin.theory.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentController {
    private static final String UPLOAD_PATH = "D:\\IT210\\Session_7\\src\\main\\webapp\\images\\";
    private final List<Student> students = new ArrayList<>(List.of(
            new Student(1L, "Atmin", 20, Gender.MALE, "tran_tri_duong.png"),
            new Student(2L, "Mynato", 20, Gender.MALE, "nguyen_nhat_minh.png"),
            new Student(3L, "Alice", 20, Gender.FEMALE, "le_duy_minh.png")
    ));

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", students);
        return "home";
    }

    @GetMapping("/add-student")
    public String showForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "form";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute("student") StudentDTO dto, RedirectAttributes attr, Model model) {
        String error = validateStudent(dto);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("student", dto);
            return "form";
        }

        String fileName = null;
        if (dto.getAvatar() != null && !dto.getAvatar().isEmpty()) {
            fileName = uploadFile(dto.getAvatar(), model, dto);
            if (fileName == null) return "form";
        }

        Optional<Student> exist = students.stream().filter(s -> s.getId() != null && s.getId().equals(dto.getId())).findFirst();
        if (fileName == null && exist.isPresent()) {
            fileName = exist.get().getAvatar();
        }

        Student student = new Student(dto.getId(), dto.getName(), dto.getAge(), dto.getGender(), fileName);
        if (student.getId() == null) {
            long maxId = students.stream().mapToLong(Student::getId).max().orElse(0L);
            student.setId(maxId + 1);
        }

        exist.ifPresent(students::remove);
        students.add(student);
        attr.addFlashAttribute("message", "Lưu dữ liệu thành công!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable long id) {
        Optional<Student> s = students.stream().filter(st -> st.getId() == id).findFirst();
        if (s.isPresent()) {
            Student st = s.get();
            model.addAttribute("student", new StudentDTO(st.getId(), st.getName(), st.getAge(), st.getGender()));
        } else {
            model.addAttribute("student", new StudentDTO());
        }
        return "form";
    }

    private String validateStudent(StudentDTO dto) {
        if (dto.getName() == null || dto.getName().trim().isEmpty()) return "Tên không được trống!";
        if (dto.getAge() == null || dto.getAge() < 1 || dto.getAge() > 120) return "Tuổi phải từ 1 đến 120!";
        if (dto.getGender() == null) return "Vui lòng chọn giới tính!";
        return null;
    }

    private String uploadFile(MultipartFile file, Model model, StudentDTO dto) {
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.trim().isEmpty()) {
            model.addAttribute("error", "Tên file không hợp lệ");
            model.addAttribute("student", dto);
            return null;
        }

        try {
            File dir = new File(UPLOAD_PATH);
            if (!dir.exists() && !dir.mkdirs()) throw new IOException("Không thể tạo thư mục");
            file.transferTo(new File(UPLOAD_PATH + fileName));
            return fileName;
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi tải file: " + e.getMessage());
            model.addAttribute("student", dto);
            return null;
        }
    }
}

