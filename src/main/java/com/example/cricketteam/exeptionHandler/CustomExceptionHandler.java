package com.example.cricketteam.exeptionHandler;

import com.example.cricketteam.Dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler( ObjectNotFoundException.class )
    public ResponseEntity<ApiError> handleObjectNotFoundException(Exception ex) {
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST, "No Content Found For This Request", ex);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST, "Validation Error", fieldErrors.get(0).getDefaultMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler( HttpMessageNotReadableException.class )
    public ResponseEntity<ApiError> handleMessageNotReadableException(Exception ex) {
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST, "Invalid Input", ex);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
