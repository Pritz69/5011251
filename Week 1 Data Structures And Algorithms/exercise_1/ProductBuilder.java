package exercise_1;

public class ProductBuilder {
    private final int productId;
    private String productName;
    private int quantity;
    private double price;

    public ProductBuilder(int productId) {
        this.productId = productId;
    }

    public ProductBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(this);
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
