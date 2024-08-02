package exercise_1;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> inventory;

    public InventoryManager() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }
   
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } 
        else {
            System.out.println("Product not found!");
        }
    }
    
    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }
}