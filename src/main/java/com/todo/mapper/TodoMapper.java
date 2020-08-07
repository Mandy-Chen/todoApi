package com.todo.mapper;

import com.todo.dto.TodoRequest;
import com.todo.dto.TodoResponse;
import com.todo.model.Todo;
import org.springframework.beans.BeanUtils;

public class TodoMapper {
    public Todo toTodo(TodoRequest todoRequest) {
        return new Todo(
                todoRequest.getId(),
                todoRequest.getContent(),
                todoRequest.getStatus(),
                todoRequest.getCreateTime()
        );
    }

    public static TodoResponse toTodoResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(todo, todoResponse);
        return todoResponse;
    }

}
