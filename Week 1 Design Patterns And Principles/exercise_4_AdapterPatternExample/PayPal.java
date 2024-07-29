package exercise_4_AdapterPatternExample;

public class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}