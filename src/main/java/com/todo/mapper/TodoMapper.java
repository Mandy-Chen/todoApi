package com.todo.mapper;

import com.todo.dto.TodoRequest;
import com.todo.model.Todo;

public class TodoMapper {
    public Todo toTodo(TodoRequest todoRequest) {
        return new Todo(
                todoRequest.getId(),
                todoRequest.getContent(),
                todoRequest.getStatus(),
                todoRequest.getCreateTime()
        );
    }

}
