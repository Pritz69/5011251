package exercise_1;

public class Product {
    private final int productId;
    private final String productName;
    private final int quantity;
    private final double price;

    
    Product(ProductBuilder builder) {
        this.productId = builder.getProductId();
        this.productName = builder.getProductName();
        this.quantity = builder.getQuantity();
        this.price = builder.getPrice();
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}