package com.todo.mapper;

import com.todo.dto.TodoRequest;
import com.todo.dto.TodoResponse;
import com.todo.model.Todo;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoMapperTest {
    @Test
    void should_get_todo_when_mapper_given_todo_request() {
        //given
        TodoMapper todoMapper = new TodoMapper();
        TodoRequest todoRequest = new TodoRequest(0, "mandy", false, new Date());
        //when
        Todo todo = todoMapper.toTodo(todoRequest);
        //then
        assertEquals(todoRequest.getId(), todo.getId());
        assertEquals(todoRequest.getContent(), todo.getContent());
        assertEquals(todoRequest.getStatus(), todo.getStatus());
        assertEquals(todoRequest.getCreateTime(), todo.getCreateTime());
    }

    @Test
    void should_get_todo_when_mapper_given_todo_response() {
        //given
        TodoMapper todoMapper = new TodoMapper();
        Todo todo = new Todo(0, "mandy", false, new Date());
        //when
        TodoResponse todoResponse = TodoMapper.toTodoResponse(todo);
        //then
        assertEquals(todoResponse.getId(), todo.getId());
        assertEquals(todoResponse.getContent(), todo.getContent());
        assertEquals(todoResponse.getCreateTime(), todo.getCreateTime());
        assertEquals(todoResponse.getStatus(), todo.getStatus());

    }
}
