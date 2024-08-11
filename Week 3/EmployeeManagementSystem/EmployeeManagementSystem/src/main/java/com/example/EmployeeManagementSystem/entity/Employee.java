package com.example.EmployeeManagementSystem.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.hibernate.type.NumericBooleanType;
@SuppressWarnings("unused")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    
    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
    
    @Column(name = "active")
    //@Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;

    @Formula("(select count(*) from orders o where o.employee_id = id)")
    private int orderCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
}

/*

2. Named Queries
Named queries are pre-defined queries that are defined using annotations. They are often used when you want to reuse the same query in multiple places.

a. Define Named Queries Using @NamedQuery
You can define named queries in the entity class using the @NamedQuery annotation.

Example:


package com.example.EmployeeManagementSystem.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByDepartmentName",
                query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName"),
    @NamedQuery(name = "Employee.findByEmailLike",
                query = "SELECT e FROM Employee e WHERE e.email LIKE :email")
})
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    private Department department;

    // Getters and setters...
}

//@NamedQueries: This is used to define multiple named queries at the entity level.
//@NamedQuery: Defines a single named query.
//name: The name of the query, which will be used to refer to it in the repository.
//query: The JPQL query string.



b. Executing Named Queries
Once you've defined a named query, you can call it in your repository using the @Query annotation with the value attribute set to the query's name.

Example:

package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Execute named query to find employees by department name
    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    // Execute named query to find employees by partial email match
    @Query(name = "Employee.findByEmailLike")
    List<Employee> findByEmailLike(@Param("email") String email);
}

//@Query(name = "Employee.findByDepartmentName"): Executes the named query Employee.findByDepartmentName.
//@Query(name = "Employee.findByEmailLike"): Executes the named query Employee.findByEmailLike.

*/
