package com.example.cricketteam.exeptionHandler;

import com.example.cricketteam.Dto.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler( ObjectNotFoundException.class )
    public ResponseEntity<ApiError> handleObjectNotFoundException(Exception ex) {
        ApiError apiError=new ApiError(HttpStatus.FORBIDDEN, "No Content Found For This Request", ex);
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);

    }


}
