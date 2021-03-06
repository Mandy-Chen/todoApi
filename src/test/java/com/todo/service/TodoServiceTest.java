package com.todo.service;

import com.todo.exception.ApiException;
import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class TodoServiceTest {
    @Mock
    TodoRepository mockedTodoRepository;
    @InjectMocks
    TodoService todoService;

    @Test
    void should_return_todo_when_add_todo_given_todo() throws ApiException {
        //given
        Todo todo = new Todo(1, "mandy", false, new Date());
        given(mockedTodoRepository.save(todo)).willReturn(todo);
        //when
        Todo actualTodo = todoService.addTodo(todo);
        //then
        assertEquals(todo, actualTodo);
    }

    @Test
    void should_return_all_todos_when_get_all_todos_given_nothing() {
        //given
        Todo firstTodo = new Todo(1, "mandy1", false, new Date());
        Todo secondTodo = new Todo(2, "mandy2", false, new Date());
        List<Todo> todos = Arrays.asList(firstTodo, secondTodo);
        given(mockedTodoRepository.findAll()).willReturn(todos);
        //when
        List<Todo> actualTodos = todoService.getAllTodos();
        //then
        assertEquals(todos, actualTodos);
    }

    @Test
    void should_updated_todo_when_put_todo_given_todo() {
        //given
        Todo beforeTodo = new Todo(1, "mandy", false, null);
        Todo updatedTodo = new Todo(1, "mandy", true, null);
        //when
        given(mockedTodoRepository.findById(1)).willReturn(Optional.of(beforeTodo));
        given(mockedTodoRepository.save(beforeTodo)).willReturn(updatedTodo);
        Todo actualUpdatedTodo = todoService.updateTodo(1, updatedTodo);
        //then
        assertEquals(updatedTodo, actualUpdatedTodo);
    }

    @Test
    void should_return_nothing_when_delete_todo_given_todo() {
        //given
        //when
        todoService.deleteTodo(1);
        //then
        verify(mockedTodoRepository, times(1)).deleteById(1);
    }
}
