package exercise_11_DependencyInjectionExample;

public class Customer {
	 private String id;
	 private String name;
	
	 public Customer(String id, String name) {
	     this.id = id;
	     this.name = name;
	 }
	
	 public String getId() {
	     return id;
	 }
	
	 public String getName() {
	     return name;
	 }
	
	 @Override
	 public String toString() {
	     return "Customer{id='" + id + "', name='" + name + "'}";
	 }
}
