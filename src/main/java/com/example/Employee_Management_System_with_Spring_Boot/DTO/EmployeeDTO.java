package com.example.Employee_Management_System_with_Spring_Boot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int empId;
    private String empName;
    private String empAddress;
    private String empMobileNo;
}
