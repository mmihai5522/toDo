package com.example.todo.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RestController("api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    // Get a task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    // Update a task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id
            , @RequestBody Task taskDetails) {
        return taskService.update(id, taskDetails)
                .map(updatedTask -> ResponseEntity.ok().body(updatedTask))
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        return taskService.deleteById(id)
                .map(deletedTask -> ResponseEntity.ok().<Void>build())
                .orElse(ResponseEntity.notFound().build());
    }
}
