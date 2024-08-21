package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring") 
public interface BookMapper {
    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);
}
