package com.demo.s4c2exam.service;

import com.demo.s4c2exam.model.EmployeeModel;
import com.demo.s4c2exam.repo.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repo;

    public List<EmployeeModel> getAll() { return repo.findAll(); }
    public EmployeeModel save(EmployeeModel e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }
    public EmployeeModel getById(Long id) { return repo.findById(id).orElse(null); }
    public List<EmployeeModel> search(String keyword) { return repo.findByNameContainingIgnoreCase(keyword); }
}
