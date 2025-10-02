package com.demo.s4c2exam.repo;

import com.demo.s4c2exam.model.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectModel, Integer> {
    List<SubjectModel> findBySubjectNameContainingIgnoreCase(String keyword);
}