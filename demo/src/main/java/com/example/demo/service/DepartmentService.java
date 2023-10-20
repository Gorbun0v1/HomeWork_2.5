package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployeesByDepartment(int departmentId);

    double getSumOfSalariesByDepartment(int departmentId);

    double getMaxSumOfSalariesByDepartment(int departmentId);

    double getMinOfSalariesByDepartment(int departmentId);

    Map<Integer, List<Employee>> getMapOfEmployeesByDepartment();
}
