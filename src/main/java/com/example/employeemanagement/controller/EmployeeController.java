package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.projections.EmployeeNameView;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = service.getEmployeeById(id);
        return employee.map(emp -> "Found: " + emp.getName())
                       .orElse("Employee not found");
    }

    @GetMapping("/names")
    public List<EmployeeNameView> getEmployeeNamesByDepartment(@RequestParam String dept) {
        return service.getEmployeeNamesByDepartment(dept);
    }

    @GetMapping("/dtos")
    public List<EmployeeDTO> getAllEmployeeDTOs() {
        return service.getAllEmployeesDTO();
    }
}
