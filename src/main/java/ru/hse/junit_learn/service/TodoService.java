package ru.hse.junit_learn.service;

import org.springframework.stereotype.Service;
import ru.hse.junit_learn.dto.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodo();
    public List<Todo> findByPriority(Integer priority);
    public Todo addTodo(Todo todo);
    public long deleteTodoByDescription(String description);

    public List<Todo> findByPriorityTested(Integer priority);
    public List<Todo> findByDescription(String description);
}
