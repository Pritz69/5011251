package singleResponsibilityPrinciple;
public class Example {

}
/*
1. Single Responsibility Principle (SRP)

Definition: A class should have only one reason to change, meaning that it should have only one job or responsibility.

Example: Consider a class that handles both reading data from a file and processing that data.
This violates SRP because if either reading the file format changes or how the data is processed changes,
the class needs to change.

----------------------------------------------------------------------------------------------------------

Bad design violating SRP

class DataProcessor {
    public void readFile(String fileName) {
        // logic to read file
    }

    public void processData() {
        // logic to process data
    }
}

----------------------------------------------------------------------------------------------------------

Better design following SRP

class DataReader {
    public void readFile(String fileName) {
        // logic to read file
    }
}

class DataProcessor {
    public void processData(Data data) {
        // logic to process data
    }
}

*/
