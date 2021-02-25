package com.example.lambda.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Employee")
public class Employee {

    @Id
    @Column(name="employeeId")
    private String employeeId;
    @Column(name="employeeName")
    private String employeeName;
    @Column(name="employeeAge")
    private Integer employeeAge;
    @Column(name="employeeSalary")
    private Double employeeSalary;


}
