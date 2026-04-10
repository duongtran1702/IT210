package org.example.minipj.repository;

import org.example.minipj.model.Course;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepository {

     private List<Course> courses = new ArrayList<>(
                Arrays.asList(
                        new Course("ENG-101", "Tiếng Anh Giao Tiếp Nhập Môn", "Beginner", 3000000.0, "Học phát âm chuẩn và giao tiếp cơ bản", "Nguyễn Văn A", "2 tháng", 15, true, LocalDate.of(2026, 5, 1)),
                        new Course("IELTS-5.0", "Luyện thi IELTS 5.0", "Intermediate", 6000000.0, "Xây dựng nền tảng từ vựng và ngữ pháp IELTS", "Trần Thị B", "3 tháng", 10, false, LocalDate.of(2026, 5, 15)),
                        new Course("IELTS-6.5", "Luyện thi IELTS 6.5+", "Advanced", 8500000.0, "Tăng cường kỹ năng Writing và Speaking chuyên sâu", "John Doe", "4 tháng", 0, false, LocalDate.of(2026, 6, 1)),
                        new Course("TOEIC-500", "Luyện thi TOEIC 500", "Beginner", 4000000.0, "Làm quen cấu trúc đề thi TOEIC", "Lê Văn C", "2 tháng", 0, false, LocalDate.of(2026, 5, 20)),
                        new Course("BUS-ENG", "Tiếng Anh Thương Mại", "Advanced", 9000000.0, "Kỹ năng viết email, thuyết trình và đàm phán", "Sarah Smith", "3 tháng", 5, false, LocalDate.of(2026, 6, 10))
                )
            );

     public  List<Course> findAll() {
         return courses;
     }

     public Course findByCode(String code) {
         return courses.stream()
                 .filter(course -> course.getCode().equals(code))
                 .findFirst()
                 .orElse(null);
     }

     public void update(Course updatedCourse) {
         Course existing = findByCode(updatedCourse.getCode());
        if (existing!=null) {
            existing.setCode(updatedCourse.getCode());
            existing.setDescription(updatedCourse.getDescription());
        }
     }

    public void delete(String code) {
        courses.removeIf(c -> c.getCode().equals(code));
    }
}
