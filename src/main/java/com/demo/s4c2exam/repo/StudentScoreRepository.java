package com.demo.s4c2exam.repo;

import com.demo.s4c2exam.model.StudentScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScoreModel, Integer> {
}
