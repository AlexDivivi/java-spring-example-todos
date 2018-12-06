package de.neuefische.todos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Todo not found")
public class TodoNotFoundException extends RuntimeException {
}
