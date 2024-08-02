package dependencyInversionPrinciple;
public class Example {

}

// https://www.baeldung.com/solid-principles

// https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2

/*

5. Dependency Inversion Principle (DIP):

Definition: High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

Example: Using interfaces or abstract classes to decouple high-level modules from low-level modules.
 
--------------------------------------------------------------------------------------------------------------------
// Bad design violating DIP
class LightBulb {
    public void turnOn() {
        // logic to turn on light bulb
    }
}

class Switch {
    private LightBulb bulb;

    public Switch() {
        this.bulb = new LightBulb(); // Dependency on concrete implementation
    }

    public void flip() {
        bulb.turnOn();
    }
}

--------------------------------------------------------------------------------------------------------------------
Better design following DIP

interface Switchable {
    void turnOn();
}

//Purpose: This interface provides an abstraction for anything that can be turned on. The Switch class will use this interface instead of depending directly on a specific implementation like LightBulb.
//Benefit: This allows us to replace the LightBulb with any other device that implements Switchable without changing the Switch class.

class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        // logic to turn on light bulb
    }
}

// LightBulb is a low-level module that conforms to the Switchable interface, allowing it to be controlled by the Switch class without Switch needing to know the details of how a light bulb works.

class Switch {											// high level module
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device; // Depend on abstraction
    }

    public void flip() {
        device.turnOn();
    }
}

// The constructor takes a Switchable device as a parameter, allowing the Switch class to be decoupled from specific implementations.
// flip() Method: This method calls turnOn() on the Switchable device, which can be any device implementing the Switchable interface (e.g., LightBulb, Fan, etc.).


Additional Example
To further illustrate, you can create another device, such as a Fan, that implements the Switchable interface:


class Fan implements Switchable {
    @Override
    public void turnOn() {
        // logic to turn on fan
    }
}
Now, you can use the Switch class with a Fan instead of a LightBulb:

public class Main {
    public static void main(String[] args) {
        Switchable fan = new Fan();
        Switch switchControl = new Switch(fan);
        switchControl.flip(); // Turns on the fan
    }
}
This demonstrates the flexibility and maintainability provided by the Dependency Inversion Principle, as the high-level Switch class can work with any Switchable device without knowing its specific implementation.
*/
