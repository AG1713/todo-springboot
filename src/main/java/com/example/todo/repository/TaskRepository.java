package com.example.todo.repository;

import com.example.todo.models.Task;
import com.example.todo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // CRUD operations are managed by this repo itself automatically
    List<Task> findByUser(User user);

}
