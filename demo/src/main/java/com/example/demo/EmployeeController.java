package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final JavaEmployeeService employeeService;

    public EmployeeController(JavaEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.delEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName ") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }
    @GetMapping("/allEmployee")
    public Employee retern(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.reternEmployee(firstName, lastName);
    }
}
