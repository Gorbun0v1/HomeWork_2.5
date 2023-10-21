package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentServiceImpl departmentService;

    List<Employee> employeesList;

    @BeforeEach
    public void setUp() {
        employeesList = List.of(
                new Employee("Ваня", "Иванов", 20, 1),
                new Employee("Таня", "Ивано", 21, 1),
                new Employee("Оля", "Иванов", 22, 1),
                new Employee("Олег", "Иванов", 23, 2),
                new Employee("Димитрий", "Иванов", 24, 3)
        );
        when(employeeService.getEmployees()).thenReturn(employeesList); //when - когда
    }

    @Test
    void getEmployeesByDepartment() {
        assertEquals(List.of(
                new Employee("Ваня", "Иванов", 20, 1),
                new Employee("Таня", "Ивано", 21, 1),
                new Employee("Оля", "Иванов", 22, 1)
        ),departmentService.getEmployeesByDepartment(1));
    }

    @Test
    void getSumOfSalariesByDepartment() {
        assertEquals(63.0,departmentService.getSumOfSalariesByDepartment(1));
    }

    @Test
    void getMaxSumOfSalariesByDepartment() {
        assertEquals(22.0,departmentService.getMaxSumOfSalariesByDepartment(1));
    }
    @Test
    void getMaxSumOfSalariesByDepartmentThrow() {
        assertThrows(RuntimeException.class, () -> departmentService.getMaxSumOfSalariesByDepartment(10));
    }


    @Test
    void getMinOfSalariesByDepartment() {
        assertEquals(20.0,departmentService.getMinOfSalariesByDepartment(1));
    }
    @Test
    void getMinSumOfSalariesByDepartmentThrow() {
        assertThrows(RuntimeException.class, () -> departmentService.getMinOfSalariesByDepartment(10));
    }


    @Test
    void getMapOfEmployeesByDepartment() {
        assertEquals(employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)),departmentService.getMapOfEmployeesByDepartment());
    }
}