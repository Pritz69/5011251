package com.example.BookstoreAPI.exception;

public class ErrorResponse {
    private int statusCode;
    private String message;

    // Constructor
    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    // Getters and Setters (optional)
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}
    
}
