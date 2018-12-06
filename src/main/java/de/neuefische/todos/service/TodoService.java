package de.neuefische.todos.service;

import de.neuefische.todos.exception.TodoNotFoundException;
import de.neuefische.todos.model.Todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return this.todos;
    }

    public Todo addTodo(String name) {
        Todo todo = new Todo(name);
        this.todos.add(todo);
        return todo;
    }

    public Todo toggleTodo(String id) {
        Todo todo = getById(id);
        todo.toggle();
        return todo;
    }

    public void deleteTodo(String id) {
        Todo todo = getById(id);
        todos.remove(todo);
    }

    private Todo getById(String id) {
        return todos.stream().filter(t -> t.getId().equals(id))
                .findAny().orElseThrow(TodoNotFoundException::new);
    }
}
