package exercise_11_DependencyInjectionExample;

public class DependencyInjectionTest {
    public static void main(String[] args) {
    	
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer1 = new Customer("1", "John Doe");
        customerService.addCustomer(customer1);

        Customer customer2 = new Customer("2", "Jane Doe");
        customerService.addCustomer(customer2);

        Customer foundCustomer1 = customerService.getCustomerById("1");
        System.out.println(foundCustomer1);

        Customer foundCustomer2 = customerService.getCustomerById("2");
        System.out.println(foundCustomer2);

        Customer nonExistentCustomer = customerService.getCustomerById("3");
        System.out.println(nonExistentCustomer);  
    }
}

/*

Benefits of Dependency Injection
Decoupling:

Promotes loose coupling by separating the creation of an object's dependencies from its behavior. This improves modularity and maintainability.
Testability:

Makes it easier to unit test classes by allowing mock or stub implementations of dependencies to be injected during testing.
Flexibility:

Allows for easy swapping of implementations without changing the client code. For example, you could switch from CustomerRepositoryImpl to another implementation without modifying CustomerService.
Maintainability:

Reduces the risk of hard-coded dependencies, making the system easier to manage and extend.
Readability:

Enhances the readability and clarity of the code by explicitly stating dependencies through constructors or setters, making the class's requirements clear.

*/