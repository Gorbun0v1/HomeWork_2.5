package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService implements JavaEmployeeService {

    Map<String, Employee> allEmployees;

    public EmployeeService() {
        this.allEmployees = new HashMap<>();
    }
    int maxAmountEmp = 10;

    public Employee addEmployee(String name, String surname) {
        if (allEmployees.size() == maxAmountEmp) {
            throw new EmployeeStorageIsFullException("Превышаемое количество сотрудников");
        }
        if (allEmployees.containsKey(name + surname)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем и фамилией уже существует");
        }
        Employee newPeople = new Employee(name, surname);
        allEmployees.put(name + surname, newPeople);
        return newPeople;
    }

    public Employee delEmployee(String name, String surname) {
        if (allEmployees.containsKey(name + surname)) {
            Employee people = allEmployees.get(name + surname);
            allEmployees.remove(name + surname);
            return people;
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем или фамилией нету");
    }

    public Employee getEmployee(String name, String surname) {
        if (allEmployees.containsKey(name + surname)) {
            return (allEmployees.get(name + surname));
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем или фамилией нету");
    }
    public Map<String,Employee> getAllEmployees() {
        return allEmployees;
    }
}



