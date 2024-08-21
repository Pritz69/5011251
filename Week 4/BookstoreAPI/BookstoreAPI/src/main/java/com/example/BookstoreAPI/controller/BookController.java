package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.exception.ResourceNotFoundException;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<BookDTO>>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<EntityModel<BookDTO>> bookDTOs = books.stream()
            .map(book -> {
                BookDTO bookDTO = bookMapper.toDTO(book);
                return EntityModel.of(bookDTO,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books"));
            })
            .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(bookDTOs,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            BookDTO bookDTO = bookMapper.toDTO(book.get());
            return ResponseEntity.ok(EntityModel.of(bookDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books")));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<EntityModel<BookDTO>> createBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book createdBook = bookService.createBook(book);
        BookDTO createdBookDTO = bookMapper.toDTO(createdBook);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/books/" + createdBookDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
            .headers(headers)
            .body(EntityModel.of(createdBookDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(createdBookDTO.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        try {
            Book book = bookMapper.toEntity(bookDTO);
            Book updatedBook = bookService.updateBook(id, book);
            BookDTO updatedBookDTO = bookMapper.toDTO(updatedBook);

            return ResponseEntity.ok(EntityModel.of(updatedBookDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books")));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}




