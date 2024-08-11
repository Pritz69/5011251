package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.dto.EmployeeNameEmailDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
@SuppressWarnings("unused")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	/* 
	Using Keywords in Method Names
	Spring Data JPA allows you to create custom query methods simply by following naming conventions.
	The framework will automatically generate the queries based on these method names.
	
	// Find all employees with a specific department name
    List<Employee> findByDepartmentName(String departmentName);

    // Find all employees whose name starts with a specific prefix
    List<Employee> findByNameStartingWith(String prefix);

    // Find all employees whose email contains a specific domain
    List<Employee> findByEmailContaining(String domain);
    */

	/*
	 b. Implementing Custom Query Methods Using @Query Annotation
	 If the method name-based query generation doesn't cover your needs, you can write custom queries using the @Query annotation.
	*/
	
    // Custom query using JPQL to find employees by department name
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    // Custom query using JPQL to find employees by partial email match
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:email%")
    List<Employee> findEmployeesByEmailLike(@Param("email") String email);

    // Custom query using JPQL to find employees by name and sort by email
    @Query("SELECT e FROM Employee e WHERE e.name = :name ORDER BY e.email ASC")
    List<Employee> findEmployeesByNameOrderedByEmail(@Param("name") String name);
    
    // Fetch name and email using the projection
    List<EmployeeNameEmailProjection> findAllBy();
    
    // Fetch name and email and map to DTO
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeNameEmailDTO(e.name, e.email) FROM Employee e")
    List<EmployeeNameEmailDTO> findAllNameEmail();

	void clear();
}

/*

1. Overview of Spring Data Repositories
Spring Data JPA Repositories simplify data access layers by providing ready-made implementations for common CRUD operations (Create, Read, Update, Delete) without needing to write boilerplate code.

Benefits of Using Spring Data Repositories:
Simplified CRUD Operations: Automatically provides CRUD methods like save(), findById(), findAll(), deleteById(), etc.
Query Generation: You can define custom query methods using method naming conventions without writing actual SQL or JPQL.
Pagination and Sorting: Supports pagination and sorting out of the box.
Type Safety: Generic types ensure compile-time type safety.
Integration with Spring Framework: Seamless integration with Spring's dependency injection and transaction management.

EmployeeRepository extends JpaRepository<Employee, Long>: This interface extends JpaRepository, which provides basic CRUD methods for the Employee entity.
findByDepartmentName(String departmentName): This method is a derived query method that finds all employees belonging to a specific department. Spring Data JPA will automatically generate the query based on the method name.
findByEmail(String email): This method fetches an employee by their email address.

*/