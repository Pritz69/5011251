package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.repository.BookRepository;
import com.example.library.model.Book;

@Service
public class BookService {

	private BookRepository bookRepository;

    // Constructor for constructor injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter method for setter injection
    @Autowired
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


