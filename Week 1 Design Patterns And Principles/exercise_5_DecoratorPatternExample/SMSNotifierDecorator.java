package exercise_5_DecoratorPatternExample;

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

//Purpose: Extends NotifierDecorator to add SMS notification functionality.
//Constructor: Calls the constructor of NotifierDecorator to set the wrapped notifier.
//Method Implementation: Overrides the send method to first call the base send method and then add additional functionality to send an SMS notification.

/*
The Decorator Pattern is used for several reasons:

Dynamic Behavior Addition:

It allows you to add responsibilities to objects dynamically and transparently without affecting other objects.

Single Responsibility Principle:

It promotes adherence to the Single Responsibility Principle by allowing functionality to be divided between classes with unique areas of concern.

Flexible and Reusable Code:

Since decorations are added at runtime, you can create a flexible and reusable code base. Different combinations of functionalities can be achieved by using different decorators.

Open/Closed Principle:

The pattern supports the Open/Closed Principle, meaning classes can be extended with new behavior without modifying existing code.

Reduction of Subclass Explosion:

Instead of creating numerous subclasses for every combination of behaviors, decorators allow you to compose behaviors dynamically, reducing the need for a large inheritance hierarchy.
*/