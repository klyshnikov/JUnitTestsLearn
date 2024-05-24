package ru.hse.junit_learn.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hse.junit_learn.dto.Todo;
import ru.hse.junit_learn.service.TodoService;

import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping("/api/v1");
public class TodoControllerImpl {
    @Autowired
    TodoService todoService;

    @GetMapping("/get-all")
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @PostMapping("/add-todo")
    public Todo addTodo(String description, Integer integer) {
        return todoService.addTodo(new Todo(integer, description));
    }

}
