package com.todo;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class TodoServiceTest {
    @Mock
    TodoRepository mockedTodoRepository;
    @InjectMocks
    TodoService todoService;

    @Test
    void should_return_todo_when_add_todo_given_todo() {
        //given
        Todo todo = new Todo(1, "mandy", false, new Date());
        given(mockedTodoRepository.save(todo)).willReturn(todo);
        //when
        Todo actualTodo = todoService.addTodo(todo);
        //then
        assertEquals(todo, actualTodo);
    }
}
