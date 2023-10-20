package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/sum")
    public double getSumOfSalariesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getSumOfSalariesByDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/max")
    public double getMaxSumOfSalariesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getMaxSumOfSalariesByDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/min")
    public double getMinOfSalariesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getMinOfSalariesByDepartment(departmentId);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getMapOfEmployeesByDepartment() {
        return departmentService.getMapOfEmployeesByDepartment();
    }



}
