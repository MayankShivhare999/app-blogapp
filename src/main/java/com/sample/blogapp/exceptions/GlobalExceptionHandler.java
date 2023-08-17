package com.sample.blogapp.exceptions;

import com.sample.blogapp.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArticleNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<ExceptionResponse> ResourceNotFoundExceptionHandler(Exception ex) {
        return ResponseEntity.status(404).body(ExceptionResponse
                .builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build());
    }
}
