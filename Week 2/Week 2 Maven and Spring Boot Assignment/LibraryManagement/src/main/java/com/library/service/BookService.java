package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to add a book
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    // Method to get all books
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // Method to find a book by ID
    public Book findBookById(int id) {
        return bookRepository.findBookById(id);
    }

    // Method to remove a book by ID
    public boolean removeBookById(int id) {
        return bookRepository.removeBookById(id);
    }
}
