package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
