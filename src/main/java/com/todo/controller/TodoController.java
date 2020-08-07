package com.todo.controller;

import com.todo.dto.TodoRequest;
import com.todo.dto.TodoResponse;
import com.todo.exception.ApiException;
import com.todo.mapper.TodoMapper;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.todo.mapper.TodoMapper.toTodoResponse;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;
    @Autowired
    TodoMapper todoMapper;

    @GetMapping
    public List<TodoResponse> getAllTodos() {
        System.out.println("getAllTodos");
        return todoService.getAllTodos().stream().map(TodoMapper::toTodoResponse).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse addTodo(@RequestBody TodoRequest todoRequest) throws ApiException {
        return toTodoResponse(todoService.addTodo(todoMapper.toTodo(todoRequest)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponse updateTodo(@PathVariable Integer id, @RequestBody TodoRequest todoRequest) throws ApiException {
        return toTodoResponse(todoService.updateTodo(id, todoMapper.toTodo(todoRequest)));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTodo(@PathVariable Integer id) throws ApiException {
        todoService.deleteTodo(id);
        return "delete success!";
    }

}
