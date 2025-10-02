package com.demo.s4c2exam.controller;


import com.demo.s4c2exam.model.StudentModel;
import com.demo.s4c2exam.model.StudentScoreModel;
import com.demo.s4c2exam.model.SubjectModel;
import com.demo.s4c2exam.service.StudentScoreService;
import com.demo.s4c2exam.service.StudentService;
import com.demo.s4c2exam.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scores")
public class ScoreController {
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final StudentScoreService scoreService;

    public ScoreController(StudentService studentService,
                           SubjectService subjectService,
                           StudentScoreService scoreService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.scoreService = scoreService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("scores", scoreService.getAll());
        return "scores/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("score", new StudentScoreModel());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAll());
        return "scores/form"; // trỏ đúng template
    }

    @PostMapping
    public String save(@ModelAttribute("score") StudentScoreModel score) {
        StudentModel student = studentService.getById(score.getStudent().getStudentId());
        SubjectModel subject = subjectService.getById(score.getSubject().getSubjectId());

        score.setStudent(student);
        score.setSubject(subject);

        scoreService.save(score);
        return "redirect:/scores";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        StudentScoreModel score = scoreService.getById(id);
        if (score == null) {
            return "redirect:/scores"; // không tìm thấy thì quay lại list
        }

        model.addAttribute("score", score);
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAll());

        return "scores/form"; // dùng lại form cũ
    }

}
