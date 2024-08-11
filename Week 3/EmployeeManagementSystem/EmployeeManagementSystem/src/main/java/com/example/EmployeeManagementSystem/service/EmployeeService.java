package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        final int batchSize = 30;
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));

            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and release memory
                employeeRepository.flush();
                employeeRepository.clear();
            }
        }
    }
}
