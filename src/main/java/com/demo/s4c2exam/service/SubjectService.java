package com.demo.s4c2exam.service;

import com.demo.s4c2exam.model.SubjectModel;
import com.demo.s4c2exam.repo.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<SubjectModel> getAll() {
        return subjectRepository.findAll();
    }

    public SubjectModel save(SubjectModel subject) {
        return subjectRepository.save(subject);
    }

    public void delete(Integer id) {
        subjectRepository.deleteById(id);
    }

    public SubjectModel getById(Integer id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public List<SubjectModel> searchByName(String keyword) {
        return subjectRepository.findBySubjectNameContainingIgnoreCase(keyword);
    }
}
