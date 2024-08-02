package openClosedPrinciple;
public class Example {

}
/*
2. Open/Closed Principle (OCP)

Definition: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

Example: Using interfaces and abstract classes to define contracts and then extending them without modifying existing code. 

------------------------------------------------------------------------------------------------

Bad design violating OCP 

class Shape {
    public void draw() {
        // logic to draw shape
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        // logic to draw circle
    }
}

--------------------------------------------------------------------------------------------------

Better design following OCP

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        // logic to draw circle
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        // logic to draw rectangle
    }
}

--------------------------------------------------------------------------------------------------

Explanation of the First Design (Violating OCP)

Class Modification: In the first design, if we need to add a new shape, we might have to modify the Shape class.
This violates the OCP, which states that classes should be open for extension but closed for modification.
Here, the Shape class is not designed to be extended easily without modification. The base Shape class has a draw method with no specific implementation,
which means that adding new shapes might require changes to the existing structure or the base class.

Lack of Flexibility: The design does not support the easy addition of new shapes.
If we want to add a new shape, such as Rectangle, we might end up modifying the existing Shape class to accommodate the new shape's behavior.
This lack of flexibility goes against the OCP principle.

Explanation of the Second Design (Following OCP)

Interface for Extension: The second design uses an interface Shape, which allows new shapes to be added without modifying existing code. Each new shape implements the Shape interface and provides its own draw method.

Open for Extension: By using an interface, the design is open for extension. New shapes can be added by creating new classes that implement the Shape interface. This means we can add new functionality (new shapes) without altering existing code.

Closed for Modification: The existing code (the Shape interface and its existing implementations like Circle) does not need to be modified to add new shapes. This aligns with the OCP, as it promotes adding new functionality without changing existing code.
*/
