package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.dto.EmployeeNameEmailDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    @GetMapping
    public Page<Employee> getAllEmployees(
            Pageable pageable,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String direction) {
        
        if (sortBy != null && direction != null) {
            Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        }
        
        return employeeRepository.findAll(pageable);
    }

    // Get an employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/names-emails")
    public List<EmployeeNameEmailProjection> getEmployeeNamesAndEmails() {
        return employeeRepository.findAllBy();
    }
    
    // Get all employees with only name and email (DTO)
    @GetMapping("/dto-names-emails")
    public List<EmployeeNameEmailDTO> getEmployeeNamesAndEmailsDTO() {
        return employeeRepository.findAllNameEmail();
    }

    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setDepartment(employeeDetails.getDepartment());
            return ResponseEntity.ok(employeeRepository.save(employee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
