package com.example.todo.controller;

import com.example.todo.models.Task;
import com.example.todo.models.User;
import com.example.todo.services.TaskService;
import com.example.todo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public String getTasks(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findByUsername(username);

        List<Task> tasks = taskService.getAllTasks(user);
        model.addAttribute("tasks", tasks);
        model.addAttribute("user", user);
        for (Task t : tasks) {
            System.out.println("Task title: " + t.getTitle());
        }
        return "tasks"; // Returning the name of the thymeLeaf template
        // Note that Spring Boot will look in templates for a file of this name
    }

    @PostMapping
    public String createTasks(@RequestParam String title, Principal principal){
        String username = principal.getName();
        User user = userService.findByUsername(username);
        taskService.createTask(title, user);
        return "redirect:/todo"; // Returning the name of the thymeLeaf template
        // Note that Spring Boot will look in templates for a file of this name
    }

    @GetMapping("{id}/delete")
    public String getTasks(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/todo";
    }

    @GetMapping("{id}/toggle")
    public String updateTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/todo";
    }

}
