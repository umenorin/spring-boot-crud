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
import com.ruan.projetospringbootcrud.repository.TaskReposiroty;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
    @Autowired
    private TaskReposiroty taskReposiroty;

    @GetMapping("/tasks")
    public List < Task > getAllTasks() {
        return taskReposiroty.findAll();
    }

    
    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task) {
        taskReposiroty.save(task);
        return task;
    }

    @PutMapping("/tasks")
    public Task editTask(@Valid @RequestBody Task task) {
        taskReposiroty.save(task);
        return task;
    }

    @DeleteMapping(path ="/tasks/{id}")
    public void deleteTask(@PathVariable long id){
        taskReposiroty.deleteById(id);
    }

}
