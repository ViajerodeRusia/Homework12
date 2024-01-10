package com.example.Homework12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class EmployeeAlreadyAddedException extends RuntimeException{
    private static final String defaultMessage = "Employee Already Added";
    public EmployeeAlreadyAddedException() {
        super(defaultMessage);
    }
}
