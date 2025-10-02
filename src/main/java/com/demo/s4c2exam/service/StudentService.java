package com.demo.s4c2exam.service;

import com.demo.s4c2exam.model.StudentModel;
import com.demo.s4c2exam.repo.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public List<StudentModel> getAll() {
        return repo.findAll();
    }

    public StudentModel save(StudentModel student) {
        return repo.save(student);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public StudentModel getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<StudentModel> search(String keyword) {
        return repo.findByFullNameContainingIgnoreCase(keyword);
    }
}