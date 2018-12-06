package de.neuefische.todos.model;

import java.util.UUID;

public class Todo {

    private String id;
    private String name;
    private boolean checked;

    public Todo(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.checked = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isApplied() {
        return checked;
    }
}
