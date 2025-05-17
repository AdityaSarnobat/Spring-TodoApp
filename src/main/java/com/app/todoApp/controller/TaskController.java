package com.app.todoApp.controller;

import com.app.todoApp.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TodoService todoService;

    public TaskController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String getTasks(Model model) {
        model.addAttribute("tasks", todoService.getAllTasks());
        return "tasks";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String title) {
        todoService.addTask(title);
        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        todoService.completeTask(id);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        todoService.deleteTask(id);
        return "redirect:/";
    }
}
