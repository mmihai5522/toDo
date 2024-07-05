package com.example.todo.assignment.subtask;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subtasks")
public class SubTaskController {

    private SubTaskService subTaskService;

    // Get all subtasks for a given task
    @GetMapping("/task/{taskId}")
    public List<SubTask> getAllSubtasksByTaskId(@PathVariable Long taskId) {
        return subTaskService.findAllByTaskId(taskId);
    }

    // Get a subtask by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubTask> getSubtaskById(@PathVariable Long id) {
        return subTaskService.findById(id)
                .map(subtask -> ResponseEntity.ok().body(subtask))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new subtask
    @PostMapping
    public SubTask createSubtask(@RequestBody SubTask subtask) {
        return subTaskService.save(subtask);
    }

    // Update a subtask
    @PutMapping("/{id}")
    public ResponseEntity<SubTask> updateSubtask(@PathVariable Long id
            , @RequestBody SubTask subtaskDetails) {
        return subTaskService.update(id, subtaskDetails)
                .map(updatedSubtask -> ResponseEntity.ok().body(updatedSubtask))
                .orElse(ResponseEntity.notFound().build());
    }
}
