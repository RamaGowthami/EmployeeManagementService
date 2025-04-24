package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("list", service.getAllEmployees());
        return "list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }
    // View employee details
    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        Employee emp = service.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "view"; // view.html
    }

    // Show form to edit employee
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee emp = service.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "edit"; // edit.html
    }


    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }
}
