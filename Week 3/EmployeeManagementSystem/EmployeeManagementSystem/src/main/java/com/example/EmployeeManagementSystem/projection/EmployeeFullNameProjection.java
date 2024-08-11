package com.example.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeFullNameProjection {
    
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}


/*

Summary
Interface-Based Projections: Use when you want a simple, easy-to-implement projection that doesn't require transformation.
Class-Based Projections (DTO): Use when you need more control or want to perform transformations on the data.
@Value Annotation: Use in interface-based projections to combine fields or perform custom transformations.

*/