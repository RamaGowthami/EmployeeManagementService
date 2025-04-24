package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);

}
