package com.example.Employee_Management_System_with_Spring_Boot.Controller;

import com.example.Employee_Management_System_with_Spring_Boot.DTO.EmployeeDTO;
import com.example.Employee_Management_System_with_Spring_Boot.DTO.ResponseDTO;
import com.example.Employee_Management_System_with_Spring_Boot.Service.EmployeeService;
import com.example.Employee_Management_System_with_Spring_Boot.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResponseDTO responseDTO;
    @PostMapping(value = "/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            String response = employeeService.saveEmployee(employeeDTO);
            if (response.equals("00")){

                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully Added Employee");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(response.equals("06")){

                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Employee Already Registered");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{

                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }

        }catch (Exception e){

            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
