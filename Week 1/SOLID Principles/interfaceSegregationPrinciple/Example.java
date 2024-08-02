package interfaceSegregationPrinciple;
public class Example {

}
/*
 4. Interface Segregation Principle (ISP)
 
Definition: Clients should not be forced to depend on interfaces they do not use.

Example: Avoiding large interfaces with unnecessary methods and breaking them into smaller, specific interfaces.

------------------------------------------------------------------------------------------------------------------
// Bad design violating ISP
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Robot implements Worker {
    @Override
    public void work() {
        // logic for working
    }

    @Override
    public void eat() {
        // robot doesn't eat
    }

    @Override
    public void sleep() {
        // robot doesn't sleep
    }
}

------------------------------------------------------------------------------------------------------------------

// Better design following ISP
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class Robot implements Workable {
    @Override
    public void work() {
        // logic for working
    }
}

------------------------------------------------------------------------------------------------------------------
*/
