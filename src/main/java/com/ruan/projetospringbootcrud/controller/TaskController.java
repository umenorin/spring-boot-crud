package com.ruan.projetospringbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.projetospringbootcrud.model.Task;
import com.ruan.projetospringbootcrud.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List < Task > getAllTasks() {
        return taskRepository.findAll();
    }

    
    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }

    @PutMapping("/tasks")
    public Task editTask(@Valid @RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }

    @DeleteMapping(path ="/tasks/{id}")
    public void deleteTask(@PathVariable long id){
        taskRepository.deleteById(id);
    }

}
