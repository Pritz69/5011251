package com.example.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.library.service.BookService;
import com.example.library.model.Book;

public class LibraryManagementApp2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = null;
        try {
            // Load Spring context
            context = new ClassPathXmlApplicationContext("applicationContext.xml");

            // Retrieve the bookService bean
            BookService bookService = context.getBean(BookService.class);

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
        } finally {
            if (context != null) {
                context.close();
            }
        }
    }
}
