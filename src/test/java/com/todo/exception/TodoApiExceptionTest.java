package com.todo.exception;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class TodoApiExceptionTest {
    @Autowired
    TodoService todoService;
    @Test
    void should_return_exception_when_add_given_nothing() throws ApiException {
        //given

        //when
        todoService.addTodo(new Todo());
        Throwable exception = assertThrows(ApiException.class, () -> {
            throw new ApiException("Todo cannot be empty");
        });
        //then
        assertEquals("Todo cannot be empty", exception.getMessage());
    }
}
