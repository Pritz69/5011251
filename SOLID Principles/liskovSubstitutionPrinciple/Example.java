package liskovSubstitutionPrinciple;
public class Example {

}
/*
3. Liskov Substitution Principle (LSP)

Definition: Subtypes must be substitutable for their base types without altering the correctness of the program.

Example: Ensuring that subclasses can be substituted for their base class without breaking the application.

--------------------------------------------------------------------------------------------------------------------
// Bad design violating LSP
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }
}

--------------------------------------------------------------------------------------------------------------------
// Better design following LSP
abstract class Shape {
    public abstract int area();
}

class Rectangle extends Shape {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int area() {
        return width * height;
    }
}

class Square extends Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }
}
------------------------------------------------------------------------------------------------------------------------

Explanation of the First Design (Violating LSP):

Inheritance Issue: In the first design, Square inherits from Rectangle. This inheritance relationship is problematic because a Square is not a subtype of Rectangle in terms of behavior. A Square has the constraint that its width and height must be the same, whereas a Rectangle does not have this constraint.

Behavioral Violation: When Square overrides setWidth and setHeight methods, it changes the behavior of the Rectangle class. This violates the LSP because a Square instance cannot be used interchangeably with a Rectangle instance. For example, if we have a method that accepts a Rectangle and sets its width and height independently, substituting a Square would break the expected behavior.

Explanation of the Second Design (Following LSP):

Abstract Base Class: The second design uses an abstract base class Shape with an abstract area method. This approach ensures that both Rectangle and Square provide their own implementations of the area method without imposing any specific constraints on how they manage their dimensions.

Independent Implementations: By separating Rectangle and Square into independent implementations of Shape, each class can handle its own specific requirements without interfering with each other. Rectangle has methods to set width and height independently, while Square has a method to set the side length, ensuring that its width and height are always the same.

Substitution Compliance: This design complies with the LSP because Rectangle and Square are now independent shapes that can be used interchangeably where a Shape is expected. The area method is guaranteed to be present and correctly implemented for both shapes, allowing for polymorphic behavior without unexpected side effects.
*/