package exercise_4_AdapterPatternExample;

public class PaymentProcessorFactory {
    public static PaymentProcessor getPaymentProcessor(String type) {
        if (type.equalsIgnoreCase("paypal")) {
            return new PayPalAdapter();    // Implemented Slightly Different From Stripe Adapter. No Use of Constructor here.
        } 
        else if (type.equalsIgnoreCase("stripe")) {
            return new StripeAdapter(new Stripe());
        }
        throw new IllegalArgumentException("Unknown payment processor type");
    }
}

//Adapter Pattern Usage: The Adapter pattern allows the integration of different payment gateways (PayPal, Stripe) with the same interface (PaymentProcessor). Each adapter class (PayPalAdapter, StripeAdapter) implements the PaymentProcessor interface and translates method calls to the specific methods of the payment gateways.
//Advantages: This pattern enables the use of existing payment gateway implementations without modifying their code, promoting code reusability and separation of concerns.