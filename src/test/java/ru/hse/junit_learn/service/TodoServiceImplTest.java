package ru.hse.junit_learn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.hse.junit_learn.dto.Todo;
import ru.hse.junit_learn.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {
    @InjectMocks
    private TodoServiceImpl todoService;
    @Mock
    private TodoRepository todoRepository;

    @Test
    void getAllTodo() {
        List<Todo> tasks = todoService.getAllTodo();
        Assertions.assertEquals(0, tasks.size());
    }

    @Test
    void findByPriorityTested() {
        Todo eat = new Todo(1, "you need to eat");
        Todo chill = new Todo(2, "you need to chill");
        Todo film = new Todo(1, "you need to watch film with Ryan Gosling");
        Mockito.when(todoRepository.findAll()).thenReturn(List.of(eat, chill, film));

        var firstPriority = todoService.findByPriorityTested(1);
        Assertions.assertEquals(2, firstPriority.size());
    }
}
