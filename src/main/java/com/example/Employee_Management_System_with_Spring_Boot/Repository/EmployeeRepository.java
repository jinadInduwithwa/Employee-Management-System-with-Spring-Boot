package com.example.Employee_Management_System_with_Spring_Boot.Repository;

import com.example.Employee_Management_System_with_Spring_Boot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
