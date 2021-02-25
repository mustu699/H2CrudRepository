package com.example.lambda.controller;

import com.example.lambda.entity.Employee;
import com.example.lambda.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getData")
    public List<Employee> getData() {
        return employeeService.getData();
    }

    @GetMapping("/getEmployeeData/{employeeId}")
    public Employee getEmployeeData(@PathVariable final String employeeId) {
        return employeeService.getEmployeeData(employeeId);
    }
    @GetMapping("/getEmployeeByName/{employeeName}")
    public List<Employee> getEmployeeDataByName(@PathVariable final String employeeName) {
        return employeeService.findByName(employeeName);
    }


    @PostMapping("/createData")
    public void createData(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping("/updateData")
    public void updateData(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteData")
    public void deleteData(@RequestParam String empId) {
        employeeService.deleteEmployee(empId);
    }

    @GetMapping("/getSortedData/{sortBy}")
    public List<Employee> getNameSortedData(@PathVariable final String sortBy) {
        if (sortBy.equalsIgnoreCase("employeeName"))
            return employeeService.sortByName();
        else if (sortBy.equalsIgnoreCase("employeeAge"))
            return employeeService.sortByAge();
        else
            return employeeService.sortBySalary();

    }

    @GetMapping("/getAverageSalary")
    public Double getAverageSalary() {
        return employeeService.averageSalary();

    }
    @GetMapping("/getMinMaxSalary/{searchType}")
    public Double getMinMaxSalary(@PathVariable final String searchType) {
        if(searchType.equalsIgnoreCase("min"))
        return employeeService.minSalary();
        else
            return employeeService.maxSalary();
    }

}
