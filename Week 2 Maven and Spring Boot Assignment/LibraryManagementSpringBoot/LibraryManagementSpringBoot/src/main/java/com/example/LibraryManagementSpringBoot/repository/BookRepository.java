package com.example.LibraryManagementSpringBoot.repository;

import com.example.LibraryManagementSpringBoot.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}