package com.example.demo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidRequestParameterException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestParameterException.class)
    public ResponseEntity<?> handleInvalidRequestParameterException(InvalidRequestParameterException e) {
    	return ResponseEntity.status(e.getResponse().getCode()).body(e.getResponse());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception e) {
        return ResponseEntity.internalServerError().body("Something went wrong");
    }

    // Xử lý các exception khác và trả về error response tương ứng
}