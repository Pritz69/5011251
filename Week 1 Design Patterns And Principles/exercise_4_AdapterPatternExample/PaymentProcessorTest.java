package exercise_4_AdapterPatternExample;

import java.util.Scanner;

public class PaymentProcessorTest {
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);

        System.out.println("Enter payment type (paypal, stripe):");
        String paymentType = scanner.nextLine().trim().toLowerCase();
        
        System.out.println("Enter amount:");
        Double amount = scanner.nextDouble();
        
        // Obtain a PaymentProcessor using the factory
        PaymentProcessor processor = PaymentProcessorFactory.getPaymentProcessor(paymentType);
        processor.processPayment(amount);

        scanner.close();
    }
}

// Factory Pattern Usage: The factory pattern abstracts the creation of objects, allowing the client to request an instance of PaymentProcessor without knowing the specific implementation.
// Advantages: This approach hides the complexity of object creation from the client, promotes flexibility, and makes it easier to add new payment processors in the future.


/*

public class PaymentProcessorTest {
public static void main(String[] args) {
    // Using PayPal through adapter
    PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
    payPalProcessor.processPayment(100.0);

    // Using Stripe through adapter
    PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
    stripeProcessor.processPayment(200.0);
}
}

*/