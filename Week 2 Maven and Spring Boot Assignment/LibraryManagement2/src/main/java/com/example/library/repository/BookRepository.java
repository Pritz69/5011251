package com.example.library.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public class BookRepository {
    // Methods for accessing book data
	private List<Book> books = new ArrayList<>();

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Method to find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Method to remove a book by ID
    public boolean removeBookById(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
