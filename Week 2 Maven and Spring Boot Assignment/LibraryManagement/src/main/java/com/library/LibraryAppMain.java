package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.model.Book;
import com.library.service.BookService;

public class LibraryAppMain {

    public static void main(String[] args) {
        // Load Spring context from applicationContext.xml
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean
        BookService bookService = context.getBean("bookService", BookService.class);

        // Create new books (POJOs) and add them to the service
        Book book1 = new Book(1, "Effective Java", "Joshua Bloch", "978-0134685991", 45.0);
        Book book2 = new Book(2, "Clean Code", "Robert C. Martin", "978-0132350884", 42.0);

        bookService.addBook(book1);
        bookService.addBook(book2);

        // Retrieve and print all books
        System.out.println("List of books: " + bookService.getAllBooks());

        // Find and print a book by ID
        System.out.println("Book with ID 1: " + bookService.findBookById(1));

        // Remove a book by ID and print the result
        System.out.println("Removing book with ID 1: " + bookService.removeBookById(1));

        // Retrieve and print all books after removal
        System.out.println("List of books after removal: " + bookService.getAllBooks());

        // Close the Spring context
        context.close();
    }
}


/*

In this setup:

Book instances are created directly in the main application code because they are simple data objects.(POJOs)
BookService and BookRepository are defined as beans in the Spring configuration file because they are components that need to be managed by Spring for dependency injection and lifecycle management.

Spring Beans vs. Plain Old Java Objects (POJOs)

Spring Beans:

These are objects that are managed by the Spring container.
Their lifecycle is handled by Spring, and they are typically configured in the Spring configuration file.
Examples include service classes, repository classes, and other components that require dependency injection.

POJOs:

These are simple data objects that don't need to be managed by the Spring container.
They are often created and used within the application code as needed.
Examples include entity classes, model classes, and DTOs (Data Transfer Objects).
*/