package com.example.Employee_Management_System_with_Spring_Boot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    private String code;
    private String message;
    private Object content;
}
