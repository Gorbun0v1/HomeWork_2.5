package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeAlreadyAddedException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();

    @BeforeEach
    public void setUp() {
        employeeService.addEmployee("Ваня", "Иванов", 20, 1);
        employeeService.addEmployee("Петя", "Петров", 50, 2);
    }

    @Test
    void addEmployeeList() {
        assertEquals(List.of(new Employee("Ваня", "Иванов", 20, 1), new Employee("Петя", "Петров", 50, 2)), employeeService.getEmployees());
    }
    @Test
    void addEmployeeNegative1() {
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee("Ваня", "Иванов", 20, 1));
    }
    @Test
    void addEmployeeNegative2() {
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.addEmployee("Аня", "Иванова", 20, 1));
    }


    @Test
    void delEmployee() {
        employeeService.delEmployee("Петя", "Петров");
        assertEquals(List.of(new Employee("Ваня", "Иванов", 20, 1)), employeeService.getEmployees());
    }
    @Test
    void delEmployeeNegative() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.delEmployee("Петя", "Ветров"));
    }

    @Test
    void getEmployee() {
        Employee employee1 = new Employee("Ваня", "Иванов", 20, 1);
        assertEquals(employee1, employeeService.getEmployee("Ваня", "Иванов"));
    }
    @Test
    void getEmployeeNegative() {
        assertNull(employeeService.getEmployee("Петя", "Иванов"));
    }

    @Test
    void getEmployees() {
        assertEquals(List.of(new Employee("Ваня", "Иванов", 20, 1), new Employee("Петя", "Петров", 50, 2)), employeeService.getEmployees());
    }
}