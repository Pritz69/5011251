package exercise_9_CommandPatternExample;

public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room's");
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

/*

Benefits of the Command Pattern

Encapsulation:

Encapsulates a request as an object, allowing for parameterization and queuing of requests.

Decoupling:

Decouples the object that invokes the operation from the object that performs the operation.

Flexibility:

Allows for dynamic changes in command execution, undo/redo functionality, and logging of command requests.

Open/Closed Principle:

Adheres to the Open/Closed Principle by allowing new commands to be added without modifying existing code.

*/