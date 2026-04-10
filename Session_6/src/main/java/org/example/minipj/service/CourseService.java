package org.example.minipj.service;

import org.example.minipj.model.Course;
import org.example.minipj.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> filterCourses(String level, Double maxFee) {
        return courseRepository.findAll().stream()
                .filter(c -> (level == null || level.isEmpty() || c.getLevel().equals(level)))
                .filter(c-> (maxFee == null || c.getTuitionFee() <= maxFee))
                .collect(Collectors.toList());
    }

    public Course getCourseByCode(String code) {
        return courseRepository.findByCode(code);
    }

    public void updateCourse(Course course) {
        this.courseRepository.update(course);
    }

    public boolean deleteCourseByCode(String code) {
        Course course = courseRepository.findByCode(code);
        if (course != null && course.getStudentCount() == 0) {
            this.courseRepository.delete(code);
            return true;
        }
        return false;
    }

}
