package com.example.cricketteam.Dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private int statusCode;
    private HttpStatus status;
    private String timestamp;
    private String message;
    private String debugMessage;

    private ApiError() {
        timestamp = String.valueOf(LocalDateTime.now());
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.statusCode=status.value();
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
    public ApiError(HttpStatus status, String message, Throwable ex, LocalDateTime localDateTime) {
        this.timestamp= String.valueOf(localDateTime);
        this.status = status;
        this.statusCode=status.value();
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}