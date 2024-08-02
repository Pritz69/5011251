package exercise_6;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementApp {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Harry Potter", "J.K. Rowling"));
        bookList.add(new Book(2, "Lord of the Rings", "J.R.R. Tolkien"));
        bookList.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        LibraryManager libraryManager = new LibraryManager(bookList);

        Book foundBook = libraryManager.linearSearchByTitle("Harry Potter");
        if (foundBook != null) {
            System.out.println("Linear Search Found: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
        } else {
            System.out.println("Book not found.");
        }

        libraryManager.sortBooksByTitle();

        foundBook = libraryManager.binarySearchByTitle("To Kill a Mockingbird");
        if (foundBook != null) {
            System.out.println("Binary Search Found: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }
}
