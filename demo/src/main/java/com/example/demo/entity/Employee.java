package com.example.demo.entity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Objects;
import java.util.ArrayList;
public class Employee {

    private String name;
    private String surname;
    private double salary;
    private int department;

    public Employee(String name, String surname, double salary, int department) {
        this.name = StringUtils.capitalize(name.toLowerCase());
        this.surname = StringUtils.capitalize(surname.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && department == employee.department && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, salary, department);
    }

    @Override
    public String toString() {
        return String.format("ФИО: %s %s, \n Отдел: %f, \n ЗП: %d", surname, name, salary, department );
    }

}