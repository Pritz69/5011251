package exercise_2;

public class ECommercePlatform {
    public static void main(String[] args) {
        
    	// SAMPLE INPUT FOR TESTING PURPOSES 
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "T-shirt", "Apparel"),
            new Product(4, "Shoes", "Footwear"),
            new Product(5, "Watch", "Accessories")
        };

        // Linear Search Test
        System.out.println("Linear Search:");
        Product foundProduct = SearchAlgorithms.linearSearch(products, "T-shirt");
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found.");
        }

        // Sort products for Binary Search
        SearchAlgorithms.sortProductsByName(products);

        // Binary Search Test
        System.out.println("\nBinary Search:");
        foundProduct = SearchAlgorithms.binarySearch(products, "T-shirt");
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found.");
        }
    }
}
