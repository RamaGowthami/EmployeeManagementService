package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

}
