package com.todo.exception;

import com.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class TodoApiException {
    @Autowired
    TodoService todoService;
    @Test
    void should_return_exception_when_add_given_nothing() {
        //given
        Throwable exception = assertThrows(ApiException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        //when
        todoService.addTodo(null);
        //then
        assertEquals("a message", exception.getMessage());
    }
}
