package exercise_5_DecoratorPatternExample;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create a base notifier (Concrete Component)
        Notifier baseNotifier = new EmailNotifier();

        // Decorate with SMS functionality
        Notifier smsDecorator = new SMSNotifierDecorator(baseNotifier);

        // Test sending notifications
        baseNotifier.send("Hello from Email!");
        System.out.println("------------");
        smsDecorator.send("Hello from Email and SMS!");
    }
}
