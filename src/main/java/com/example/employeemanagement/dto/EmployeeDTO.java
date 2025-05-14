package com.example.employeemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String name;
    private String department;

    public EmployeeDTO(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
