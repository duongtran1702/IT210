package org.example.minipj.controller;

import org.example.minipj.model.Course;
import org.example.minipj.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/", "/course"})
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String home(){
        return "redirect:/course/list";
    }

    @GetMapping("/list")
    public String LisCourse(
            @RequestParam(name = "level", required = false, defaultValue = "") String level,
            @RequestParam(name = "maxFee", required = false ) Double maxFee,
            @RequestParam(name = "successMessage", required = false) String successMessage,
            @RequestParam(name = "errorMessage", required = false) String errorMessage,
            Model model
    ) {
        model.addAttribute("courses", courseService.filterCourses(level, maxFee));
        model.addAttribute("selectLevel", level);
        model.addAttribute("maxFee", maxFee);
        if (successMessage != null && !successMessage.isEmpty()) {
            model.addAttribute("successMessage", successMessage);
        }
        if (errorMessage != null && !errorMessage.isEmpty()) {
            model.addAttribute("errorMessage", errorMessage);
        }
        return "course/listCourse";
    }

    @GetMapping("/detail/{code}")
    public String detail(
            @PathVariable(name = "code") String code,
            Model model
    ){
        Course course = courseService.getCourseByCode(code);
        if (course == null) return "redirect:/course/list";
        model.addAttribute("course", course);
        return "course/detail";
    }

    @GetMapping("/edit/{code}")
    public String showEditForm(
            @PathVariable(name = "code") String code,
            Model model
    ){
        Course course = courseService.getCourseByCode(code);
        if (course == null) return "redirect:/course/list";
        model.addAttribute("course", course);
        return "course/edit";
    }

    @PostMapping("/edit")
    public String editCourse(
            @ModelAttribute Course course
    ){
        courseService.updateCourse(course);
        return "redirect:/course/list?successMessage=Cập nhật khóa học thành công!";
    }

    @GetMapping("/delete/{code}")
    public String deleteCourse(
            @PathVariable(name = "code") String code
    ){
        boolean deleted = courseService.deleteCourseByCode(code);
        if (deleted) {
            return "redirect:/course/list?successMessage=Xóa khóa học thành công!";
        } else {
            return "redirect:/course/list?errorMessage=Không thể xóa khóa học này (có học viên đang theo học)!";
        }
    }
}
