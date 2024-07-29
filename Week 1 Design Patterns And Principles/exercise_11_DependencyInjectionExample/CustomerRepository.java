package exercise_11_DependencyInjectionExample;

import java.util.Optional;

public interface CustomerRepository {
	 Optional<Customer> findCustomerById(String id);
	 void addCustomer(Customer customer);
}
