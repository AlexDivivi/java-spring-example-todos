package de.neuefische.todos.controller.dto;

import de.neuefische.todos.model.Todo;

public class TodoResponseDto {

    private String id;

    private String name;

    private boolean applied;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.name = todo.getName();
        this.applied = todo.isApplied();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isApplied() {
        return applied;
    }
}
