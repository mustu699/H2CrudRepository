package com.example.lambda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
