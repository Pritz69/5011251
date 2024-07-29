package exercise_7_ObserverPatternExample;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("ABC", 100.0);

        Observer Ram = new MobileApp("Ram");
        Observer webApp1 = new WebApp("Sam");

        stockMarket.registerObserver(Ram);
        stockMarket.registerObserver(webApp1);

        // Change stock price and notify observers
        stockMarket.setStockPrice(105.0);
        System.out.println("------------");
        stockMarket.setStockPrice(110.0);
        
        // Deregister an observer
        stockMarket.deregisterObserver(webApp1);
        System.out.println("------------");
        stockMarket.setStockPrice(115.0);
    }
}

/*

Why Use the Observer Pattern?

Decoupling:

The observer pattern provides a way to decouple the subject from its observers. The subject doesn't need to know the details of its observers, only that they implement a common interface.

Dynamic Subscription:

Observers can be added and removed at runtime, allowing for a flexible and dynamic system.

Multiple Views:

Different observers can represent different views or aspects of the subject's state, providing a mechanism to keep multiple objects in sync with a central subject.

Scalability:

The pattern supports the scalability of applications. As the number of observers increases, the subject can handle notifying all observers without needing to manage them directly.

Maintainability:

By adhering to the Single Responsibility Principle, the pattern makes the system easier to maintain. Each class has a single responsibility, reducing the complexity of the system.

*/