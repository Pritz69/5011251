package exercise_4;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        // Add employees for Testing Purpose
        system.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        system.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        system.addEmployee(new Employee(3, "Charlie", "Designer", 55000));
        system.addEmployee(new Employee(4, "David", "Tester", 50000));
        system.addEmployee(new Employee(5, "Eve", "HR", 65000));

        // Traverse employees
        System.out.println("Employee List:");
        system.traverseEmployees();

        // Search for an employee - TESTING PURPOSE
        System.out.println("\nSearching for Employee with ID 3:");
        Employee emp = system.searchEmployee(3);
        if (emp != null) {
            System.out.println("Employee found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee
        System.out.println("\nDeleting Employee with ID 2:");
        boolean isDeleted = system.deleteEmployee(2);
        if (isDeleted) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }

        // Traverse employees again
        System.out.println("\nEmployee List after Deletion:");
        system.traverseEmployees();
    }
}
