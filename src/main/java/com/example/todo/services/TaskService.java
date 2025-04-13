package com.example.todo.services;

import com.example.todo.models.Task;
import com.example.todo.models.User;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(User user) {
        return taskRepository.findByUser(user);
    }

    public void createTask(String title, User user) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        task.setUser(user);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() ->  new IllegalArgumentException(("Invalid Task Id")));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);

    }
}
