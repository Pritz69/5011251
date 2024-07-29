package exercise_4_AdapterPatternExample;

public class PayPalAdapter implements PaymentProcessor {
	
    private PayPal payPal=new PayPal();

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}
