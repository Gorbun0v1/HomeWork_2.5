package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeAlreadyAddedException;
import com.example.demo.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements JavaEmployeeService {

    List<Employee> allEmployees = new ArrayList<>();
    int maxAmountEmp = 10;

    public Employee addEmployee(String name, String surname, double salary, int department) {

        if (allEmployees.stream()
                .anyMatch(employee -> name.equals(employee.getName()) && surname.equals(employee.getSurname()))
        ) throw new EmployeeAlreadyAddedException("Сотрудник с таким именем и фамилией уже существует");


        if (allEmployees.size() == maxAmountEmp) {
            throw new EmployeeStorageIsFullException("Превышаемое количество сотрудников");
        }
        Employee newPeople = new Employee(name, surname, salary, department);
        allEmployees.add(newPeople);
        return newPeople;
    }

    public Employee delEmployee(String name, String surname) {
        Employee employee1 = allEmployees.stream()
                .filter(employee -> name.equals(employee.getName()) && surname.equals(employee.getSurname()))
                .findFirst()
                .orElseThrow();//new EmployeeNotFoundException("Сотрудник с таким именем или фамилией нету"));
        allEmployees.remove(employee1);
        return employee1;
    }

    public Employee getEmployee(String name, String surname) {

        return allEmployees.stream()
                .filter(employee -> name.equals(employee.getName()) && surname.equals(employee.getSurname()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> getEmployees() {
        return allEmployees;
    }

}



