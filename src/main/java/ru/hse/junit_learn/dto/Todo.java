package ru.hse.junit_learn.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Integer priority;

    public String description;

    public Todo() {
        priority = 1;
        description = "-";
    }

    public Todo(Integer p, String d) {
        this.priority = p;
        this.description = d;
    }
}
