package exercise_1;

import java.util.Scanner;

public class InventoryApp {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Inventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    Product product = new ProductBuilder(id)
                            .withProductName(name)
                            .withQuantity(quantity)
                            .withPrice(price)
                            .build();
                    manager.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter New Product Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();

                    Product updatedProduct = new ProductBuilder(updateId)
                            .withProductName(newName)
                            .withQuantity(newQuantity)
                            .withPrice(newPrice)
                            .build();
                    manager.updateProduct(updatedProduct);
                    break;
                case 3:
                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteProduct(deleteId);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}