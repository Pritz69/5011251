package exercise_8_StrategyPatternExample;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}