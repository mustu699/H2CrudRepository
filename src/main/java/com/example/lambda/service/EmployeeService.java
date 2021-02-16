package com.example.lambda.service;

import com.example.lambda.entity.Employee;
import com.example.lambda.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeData()
    {
        return employeeRepository.findAll();
    }
    public void createEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }
}
