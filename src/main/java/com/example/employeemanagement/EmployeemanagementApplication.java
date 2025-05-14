package com.example.employeemanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementApplication.class, args);
	}

	// Initialize test data on application start
    @Bean
    CommandLineRunner init(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("Alice", "HR", 50000.0));
            repository.save(new Employee("Bob", "IT", 60000.0));
            repository.save(new Employee("Charlie", "HR", 55000.0));
        };
    }
}
