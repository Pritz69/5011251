package exercise_4_AdapterPatternExample;

public class Stripe {
    public void charge(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}