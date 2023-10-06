package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeSalaryService;
import com.example.demo.service.JavaEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeSalaryController {
    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController(EmployeeSalaryService employeeService) {
        this.employeeSalaryService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeMaxSalary(@RequestParam("departmentId") int departmentId ) {
        return employeeSalaryService.maxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeMinSalary(@RequestParam("departmentId") int departmentId ) {
        return employeeSalaryService.minSalary(departmentId);
    }
    @GetMapping("/all")
    public List<Employee> getEmployeeAll(@RequestParam("departmentId") int departmentId ) {
        return employeeSalaryService.getEmployeesByDepartment(departmentId);
    }
    @GetMapping("/all")
    public List<Employee> getEmployeeAllDepartment() {
        return employeeSalaryService.getAllEmployeesByDepartment();
    }
}
