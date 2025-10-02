package com.demo.s4c2exam.repo;

import com.demo.s4c2exam.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    List<StudentModel> findByFullNameContainingIgnoreCase(String keyword);
}