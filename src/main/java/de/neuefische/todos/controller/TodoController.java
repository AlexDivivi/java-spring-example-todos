package de.neuefische.todos.controller;

import de.neuefische.todos.controller.dto.TodoCreateDto;
import de.neuefische.todos.controller.dto.TodoResponseDto;
import de.neuefische.todos.model.Todo;
import de.neuefische.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping("/todos")
    public TodoResponseDto addTodo(@RequestBody TodoCreateDto dto) {
        Todo todo = service.addTodo(dto.getName());
        return new TodoResponseDto(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable String id) {
        service.deleteTodo(id);
    }

}
