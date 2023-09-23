package com.ruan.projetospringbootcrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.projetospringbootcrud.exception.ResourceNotFoundException;
import com.ruan.projetospringbootcrud.model.Task;
import com.ruan.projetospringbootcrud.repository.TaskRepository;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List < Task > getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping(path="/tasks/{id}")
    public Optional<Task> getTaskPerId(long id){
        return taskRepository.findById(id);
    }

    
    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity < Task > updateTask(@PathVariable(value = "id") Long taskId,
        @Valid @RequestBody Task taskDetails) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));

        task.setId(taskDetails.getId());
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        final Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public Map < String, Boolean > deleteTask(@PathVariable(value = "id") Long employeeId)
    throws ResourceNotFoundException {
        Task employee = taskRepository.findById(employeeId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

            taskRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
