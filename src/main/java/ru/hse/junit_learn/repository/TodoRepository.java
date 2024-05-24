package ru.hse.junit_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.hse.junit_learn.dto.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findAll();
    List<Todo> findByPriority(Integer priority);
    List<Todo> findByPriorityLessThan(Integer priority);
    // save - already exist
    long deleteByDescription(String description);
}
