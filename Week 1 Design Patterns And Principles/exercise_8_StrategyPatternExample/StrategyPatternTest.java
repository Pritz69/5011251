package exercise_8_StrategyPatternExample;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/23");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(100.0);
        System.out.println("------------");

        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.0);
    }
}

/*
In this example, the PaymentContext (context) initially uses a CreditCardPayment strategy and later switches to a PayPalPayment strategy.
The client code does not need to know the details of these strategies; it simply calls executePayment(),and the correct payment method is used based on the current strategy.
This flexibility and ease of interchangeability are key benefits of the Strategy Pattern.

Why Use the Strategy Pattern?
Encapsulation of Algorithms:

The Strategy Pattern encapsulates different algorithms or behaviors (in this case, payment methods) and makes them interchangeable.

Open/Closed Principle:

The pattern adheres to the Open/Closed Principle by allowing new payment strategies to be added without modifying existing code.

Single Responsibility Principle:

Each strategy class has a single responsibility, making the system easier to understand, maintain, and extend.

Dynamic Behavior:

The pattern allows the behavior of the context (payment process) to change dynamically at runtime, depending on which strategy is set.

Reusability:

Different strategies can be reused across different contexts without code duplication.

*/