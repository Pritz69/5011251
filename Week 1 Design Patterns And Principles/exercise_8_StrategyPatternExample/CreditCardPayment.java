package exercise_8_StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy {
	private String cardNumber;
    private String cardHolder;
    private String cvv;
	private String expiryDate;

    public String getCardNumber() {
		return cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public String getCvv() {
		return cvv;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public CreditCardPayment(String cardNumber, String cardHolder, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}