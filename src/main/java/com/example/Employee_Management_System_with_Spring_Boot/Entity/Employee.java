package com.example.Employee_Management_System_with_Spring_Boot.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated Id
    private int empId;
    private String empName;
    private String empAddress;
    private String empMobileNo;
}
