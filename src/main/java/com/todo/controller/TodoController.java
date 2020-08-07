package com.todo.controller;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
        return "delete success!";
    }

}
