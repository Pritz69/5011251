package exercise_11_DependencyInjectionExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public Optional<Customer> findCustomerById(String id) {
        return customers.stream()
                        .filter(customer -> customer.getId().equals(id))
                        .findFirst();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}