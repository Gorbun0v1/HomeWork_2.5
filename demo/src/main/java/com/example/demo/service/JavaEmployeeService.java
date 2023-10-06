package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface JavaEmployeeService {
    Employee addEmployee(String name, String surname, double salary, int department);
    Employee delEmployee(String name, String surname);
    Employee getEmployee(String name, String surname);
    List<Employee> getEmployees();
}
