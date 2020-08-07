package com.todo.service;

import com.todo.exception.ApiException;
import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Todo addTodo(Todo todo) throws ApiException {
        if (Objects.isNull(todo)) {
            throw new ApiException("Todo cannot be empty");
        }
        return todoRepository.save(todo);

    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos;
    }

    public Todo updateTodo(Integer id, Todo updateTodo) throws ApiException {
        if (Objects.isNull(id)) {
            throw new ApiException("id cannot be empty");
        }
        Todo todo = todoRepository.findById(id).orElse(null);
        if (Objects.isNull(todo)) {
            throw new ApiException("Todo doesn't exist！");
        }
        todo.setContent(updateTodo.getContent());
        todo.setStatus(updateTodo.getStatus());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Integer id) throws ApiException {
        if (Objects.isNull(id)) {
            throw new ApiException("id is empty！");
        }
        todoRepository.deleteById(id);
    }
}
