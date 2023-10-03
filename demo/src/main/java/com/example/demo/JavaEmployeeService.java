package com.example.demo;

import java.util.List;
import java.util.Map;

public interface JavaEmployeeService {
    Employee addEmployee(String name, String surname);
    Employee delEmployee(String name, String surname);
    Employee getEmployee(String name, String surname);
    Map<String,Employee> getAllEmployees(String name, String surname);

}
