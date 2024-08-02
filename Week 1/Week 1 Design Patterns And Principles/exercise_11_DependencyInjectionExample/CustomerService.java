package exercise_11_DependencyInjectionExample;

public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id).orElse(null);
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }
}

/*
The term "dependency injection" refers to the practice of supplying an object's dependencies from the outside rather than the object creating the dependencies itself. 
There are three common ways to achieve dependency injection: constructor injection, setter injection, and interface injection. 
In the example provided, constructor injection is used.
 
Why It’s Called Dependency Injection

Dependency:
In the context of the example, CustomerService has a dependency on CustomerRepository.
The CustomerService cannot function properly without a CustomerRepository instance.

Injection:

Instead of the CustomerService creating an instance of CustomerRepository (which would tightly couple the service
to a specific implementation), the CustomerRepository is injected into the CustomerService from the outside.
This is typically done at the time of the CustomerService's creation.

Types of Dependency Injection

Constructor Injection:

public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}

Setter Injection:

public class CustomerService {
    private CustomerRepository customerRepository;

    // Setter injection
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}


Interface Injection:

public interface CustomerService {
    void injectCustomerRepository(CustomerRepository customerRepository);
}

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public void injectCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}


*/