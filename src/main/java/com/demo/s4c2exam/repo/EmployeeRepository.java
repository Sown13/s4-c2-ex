package com.demo.s4c2exam.repo;

import com.demo.s4c2exam.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    List<EmployeeModel> findByNameContainingIgnoreCase(String name);
}
