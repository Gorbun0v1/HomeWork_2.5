package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }
    @Override
    public double getSumOfSalariesByDepartment(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
    @Override
    public double getMaxSumOfSalariesByDepartment(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .max().orElseThrow();
    }
    @Override
    public double getMinOfSalariesByDepartment(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .min().orElseThrow();
    }
    @Override
    public Map<Integer, List<Employee>> getMapOfEmployeesByDepartment() {
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
