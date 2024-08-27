package com.example.BookstoreAPI.exception;

//Custom exception class for invalid input
@SuppressWarnings("serial")
class InvalidInputException extends RuntimeException {
 public InvalidInputException(String message) {
     super(message);
 }
}