package com.example.lambda.service;

import com.example.lambda.entity.Employee;
import com.example.lambda.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void updateEmployee( Employee employee){
        Employee employeeData;
        if(employeeRepository.findById(employee.getEmployeeId()).isPresent())
        {
            employeeData =employeeRepository.findById(employee.getEmployeeId()).get();
            employeeData.setEmployeeName(employee.getEmployeeName());
        }
        else{
            employeeData=new Employee();
        }
    }
}
