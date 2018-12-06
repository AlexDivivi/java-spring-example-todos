package de.neuefische.todos.service;

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

    public void deleteTodo(String id) {
        for (Todo todo: todos) {
            if (todo.getId().equals(id)) {
                todos.remove(todo);
                return;
            }
        }
    }
}
