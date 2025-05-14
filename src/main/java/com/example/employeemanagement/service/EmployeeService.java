package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.projections.EmployeeNameView;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id); // returns Optional
    }

    public List<EmployeeNameView> getEmployeeNamesByDepartment(String department) {
        return employeeRepository.findByDepartment(department); // interface-based projection
    }

    public List<EmployeeDTO> getAllEmployeesDTO() {
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeeDTO(emp.getName(),emp.getDepartment()))
                .collect(Collectors.toList());
    }
}
