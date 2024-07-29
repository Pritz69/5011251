package exercise_1_SingletonPatternExample;

public class Logger {
    // Private static instance of Logger
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
    }

    // Public static method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

/*

The Logger class is implemented as a Singleton by:

Making the constructor private to prevent instantiation from outside the class.
Providing a public static method getInstance() to return the single instance of the class.
Using double-checked locking to ensure thread safety and lazy initialization.


The synchronized block in the getInstance method is used to ensure that only one thread can execute this block of code at a time. This is crucial in a multithreaded environment to prevent multiple threads from creating multiple instances of the Logger class.

Thread Safety: Without synchronization, if two threads simultaneously enter the if (instance == null) block, they could both create an instance of the Logger class, violating the Singleton pattern.
Double-Checked Locking: This pattern involves two checks for instance == null. The first check is outside the synchronized block to avoid the performance cost of acquiring a lock every time the getInstance method is called. The second check inside the synchronized block ensures that only one instance is created even if multiple threads reach this point at the same time.

*/