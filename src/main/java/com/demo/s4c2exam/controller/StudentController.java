package com.demo.s4c2exam.controller;

import com.demo.s4c2exam.model.StudentModel;
import com.demo.s4c2exam.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model, @RequestParam(required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("students", service.search(keyword));
        } else {
            model.addAttribute("students", service.getAll());
        }
        return "students/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new StudentModel());
        return "students/form";
    }

    // Lưu (create + update)
    @PostMapping("/save")
    public String save(@ModelAttribute("student") StudentModel student) {
        service.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        StudentModel student = service.getById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "students/form";
    }

    // Xoá bằng POST để tránh dùng GET cho hành động thay đổi state
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        service.delete(id);
        return "redirect:/students";
    }
}
