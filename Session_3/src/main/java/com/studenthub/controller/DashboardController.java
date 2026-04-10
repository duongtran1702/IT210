package com.example.controller;

import com.example.model.DashboardSummary;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final StudentService studentService;

    public DashboardController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        DashboardSummary summary = studentService.getDashboardSummary();
        model.addAttribute("summary", summary);
        return "dashboard";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }
}