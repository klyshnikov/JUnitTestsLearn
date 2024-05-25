package ru.hse.junit_learn.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.junit_learn.dto.Todo;
import ru.hse.junit_learn.repository.TodoRepository;

import java.util.List;
import java.util.Objects;

@Service
//@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    //@Autowired
    TodoRepository todoRepository;

     public TodoServiceImpl(TodoRepository todoRepository) {
         this.todoRepository = todoRepository;
     }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> findByPriority(Integer priority) {
        return todoRepository.findByPriority(priority);
    }

    @Override
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public long deleteTodoByDescription(String description) {
        return todoRepository.deleteByDescription(description);
    }

    @Override
    public List<Todo> findByPriorityTested(Integer priority) {
        var allTodo = getAllTodo();
        return allTodo.stream().filter(t -> Objects.equals(t.priority, priority)).toList();
    }

    @Override
    public List<Todo> findByDescription(String description) {
        var allTodo = getAllTodo();
        return allTodo.stream().filter(t -> Objects.equals(t.description, description)).toList();
    }


}
