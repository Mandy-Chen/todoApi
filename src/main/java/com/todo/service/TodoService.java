package com.todo.service;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo addTodo(Todo todo) {
        if (Objects.isNull(todo)) {
            System.out.println("todo为空！");
        }
        return todoRepository.save(todo);

    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        if (todos.isEmpty()) {
            System.out.println("findAll is empty!");
        }
        return todos;
    }
}
