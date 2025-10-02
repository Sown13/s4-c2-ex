package com.demo.s4c2exam.service;


import com.demo.s4c2exam.model.StudentModel;
import com.demo.s4c2exam.model.StudentScoreModel;
import com.demo.s4c2exam.model.SubjectModel;
import com.demo.s4c2exam.repo.StudentRepository;
import com.demo.s4c2exam.repo.StudentScoreRepository;
import com.demo.s4c2exam.repo.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentScoreService {
    private final StudentScoreRepository scorceRepo;
    private final StudentRepository studentRepo;
    private final SubjectRepository subjectRepo;

    public List<StudentScoreModel> getAll() {
        return scorceRepo.findAll();
    }

    public void save(StudentScoreModel score) {
        StudentModel student = studentRepo.findById(score.getStudent().getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        SubjectModel subject = subjectRepo.findById(score.getSubject().getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        score.setStudent(student);
        score.setSubject(subject);

        scorceRepo.save(score);
    }


    public StudentScoreModel getById(Integer id) {
        return scorceRepo.findById(id).orElse(null);
    }
}
