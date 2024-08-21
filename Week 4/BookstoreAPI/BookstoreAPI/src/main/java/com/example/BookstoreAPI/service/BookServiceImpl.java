package com.example.BookstoreAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
        book.setId(id); // Set the ID to ensure it updates the existing book
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
        bookRepository.deleteById(id);
    }
}

