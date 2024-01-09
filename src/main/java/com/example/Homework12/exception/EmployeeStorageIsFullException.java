package com.example.Homework12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
//ControllerAdvice почитать про него, он перехватывает
public class EmployeeStorageIsFullException extends RuntimeException {
    private static final String defaultMessage = "Storage is full";
    public EmployeeStorageIsFullException() {
        super(defaultMessage);
    }
}
