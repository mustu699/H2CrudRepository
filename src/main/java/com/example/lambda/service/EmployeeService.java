package com.example.lambda.service;

import com.example.lambda.entity.Employee;
import com.example.lambda.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getData() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeData(String employeeId) {
        return employeeRepository.findById(employeeId).get();
    }


    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        Employee employeeData;
        if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
            employeeData = employeeRepository.findById(employee.getEmployeeId()).get();
            employeeData.setEmployeeName(employee.getEmployeeName());
            employeeData.setEmployeeAge(employee.getEmployeeAge());
            employeeData.setEmployeeSalary(employee.getEmployeeSalary());
            employeeRepository.save(employeeData);
        } else {
            employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(String empId) {
        employeeRepository.deleteById(empId);
    }

    public List<Employee> sortByName() {
        List<Employee> employee=employeeRepository.findAll();
        employee.sort(Comparator.comparing(Employee::getEmployeeName));
        return employee;
    }

    public List<Employee> sortByAge() {
        List<Employee> employee=employeeRepository.findAll();
        employee.sort(Comparator.comparing(Employee::getEmployeeAge));
        return employee;
    }

    public List<Employee> sortBySalary() {
        List<Employee> employee=employeeRepository.findAll();
        employee.sort(Comparator.comparing(Employee::getEmployeeSalary));
        return employee;
    }

    public Double averageSalary() {
        List<Employee> employee=employeeRepository.findAll();
        return employee.stream().mapToDouble(Employee::getEmployeeSalary).average().orElse(0);
    }

    public Double minSalary() {
        List<Employee> employee=employeeRepository.findAll();
        return employee.stream().mapToDouble(Employee::getEmployeeSalary).min().orElse(0);
    }

    public Double maxSalary() {
        List<Employee> employee=employeeRepository.findAll();
        return employee.stream().mapToDouble(Employee::getEmployeeSalary).max().orElse(0);
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByEmployeeName(name);
    }
}
