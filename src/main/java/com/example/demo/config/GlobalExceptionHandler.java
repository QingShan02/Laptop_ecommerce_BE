package com.example.demo.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> handleInvalidRequestException(InvalidRequestParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getResponse());
    }

    // Xử lý các exception khác và trả về error response tương ứng
}