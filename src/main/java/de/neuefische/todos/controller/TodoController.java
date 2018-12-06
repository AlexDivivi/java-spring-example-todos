package de.neuefische.todos.controller;

import de.neuefische.todos.controller.dto.TodoCreateDto;
import de.neuefische.todos.controller.dto.TodoResponseDto;
import de.neuefische.todos.model.Todo;
import de.neuefische.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;


    @PostMapping("/todos")
    public TodoResponseDto addTodo(@Valid @RequestBody TodoCreateDto dto) {
        Todo todo = service.addTodo(dto.getName());
        return new TodoResponseDto(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable String id) {
        service.deleteTodo(id);
    }

    @PutMapping("todos/{id}/toggle")
    public TodoResponseDto toggleTodo(@PathVariable String id) {
        return new TodoResponseDto(service.toggleTodo(id));
    }

    @GetMapping("/todos")
    public List<TodoResponseDto> getTodos() {
        return service.getTodos().stream().map(TodoResponseDto::new).collect(Collectors.toList());
    }
}
