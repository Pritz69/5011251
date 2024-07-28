package exercise_3;

import java.util.Arrays;

public class ECommercePlatform {

    public static void main(String[] args) {
        // Sample orders for Testing Purpose
        Order[] orders = {
            new Order(1, "Alice", 250.75),
            new Order(2, "Bob", 99.99),
            new Order(3, "Charlie", 150.50),
            new Order(4, "David", 200.00),
            new Order(5, "Eve", 300.20)
        };

        System.out.println("Bubble Sort:");
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        SortingAlgorithms.bubbleSort(bubbleSortedOrders);
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        System.out.println("\nQuick Sort:");
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        SortingAlgorithms.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
