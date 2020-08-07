package com.todo.config;

import com.todo.exception.ApiException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({ApiException.class})
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public String handleApiException(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleConstraintViolationException(ConstraintViolationException exception) {
        return "Insert data exception,please check your post data!";
    }
    @ExceptionHandler({EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleCEmptyResultDataAccessException(ConstraintViolationException exception) {
        return "No class com.todo.model.Todo entity with id  exists!";
    }

}

