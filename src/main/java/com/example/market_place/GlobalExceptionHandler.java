package com.example.market_place;

import com.example.market_place.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity defaultErrorHandler(RuntimeException exception) {
        ErrorMessage message = new ErrorMessage();
        message.setError(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
