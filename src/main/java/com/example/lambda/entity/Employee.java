package com.example.lambda.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    @Column(name="employeeId")
    private String employeeId;
    @Column(name="employeeName")
    private String employeeName;
    @Column(name="salary")
    private Double salary;

}
