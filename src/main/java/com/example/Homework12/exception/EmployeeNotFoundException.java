package com.example.Homework12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
//ControllerAdvice почитать про него, он перехватывает
public class EmployeeNotFoundException extends RuntimeException {
    //TODO: как сделать чтобы выходил кастомный текст ошибки в веб странице -- сделано
    private static final String defaultMessage = "Requested employee not found";
    public EmployeeNotFoundException() {
        super(defaultMessage);
    }
}

