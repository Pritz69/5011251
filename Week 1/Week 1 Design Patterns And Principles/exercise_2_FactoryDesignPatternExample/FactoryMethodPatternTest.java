package exercise_2_FactoryDesignPatternExample;

import java.util.Scanner;

public class FactoryMethodPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter document type (word, pdf, excel):");
        String documentType = scanner.nextLine().trim().toLowerCase();

        // Get the factory based on user input
        DocumentFactory factory = DocumentFactoryProvider.getFactory(documentType);

        // Create and use the document
        Document document = factory.createDocument();
        document.open();
        document.save();
        document.close();
        
        scanner.close();
    }
}
