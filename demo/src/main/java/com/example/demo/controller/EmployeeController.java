package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.JavaEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final JavaEmployeeService employeeService;

    public EmployeeController(JavaEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") double salary, @RequestParam int department ) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.delEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }
    @GetMapping("/allEmployee")
    public List<Employee> getAllEmployees(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.getEmployees();
    }
}
