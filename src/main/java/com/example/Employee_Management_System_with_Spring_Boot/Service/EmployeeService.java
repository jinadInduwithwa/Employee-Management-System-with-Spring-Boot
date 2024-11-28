package com.example.Employee_Management_System_with_Spring_Boot.Service;

import com.example.Employee_Management_System_with_Spring_Boot.DTO.EmployeeDTO;
import com.example.Employee_Management_System_with_Spring_Boot.Entity.Employee;
import com.example.Employee_Management_System_with_Spring_Boot.Repository.EmployeeRepository;
import com.example.Employee_Management_System_with_Spring_Boot.Util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    // save the employee, if not already exist in database
    public String saveEmployee(EmployeeDTO employeeDTO){
        if(employeeRepository.existsById(employeeDTO.getEmpId())){
            return VarList.RSP_DUPLICATED;
        }else{
            employeeRepository.save(modelMapper.map(employeeDTO,Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO){
        if(employeeRepository.existsById(employeeDTO.getEmpId())){
            employeeRepository.save(modelMapper.map(employeeDTO,Employee.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<Employee> employeeList = employeeRepository.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>(){
        }.getType());

    }
}
