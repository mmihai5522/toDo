package com.example.todo.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // Get a task by ID
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    // Save a new task
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    // Update an existing task
    public Optional<Task> update(Long id, Task taskDetails) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.getCompleted());
            task.setColor(taskDetails.getColor());
            task.setProject(taskDetails.getProject());
            task.setAssignedTo(taskDetails.getAssignedTo());
            task.setDueDate(taskDetails.getDueDate());
            return taskRepository.save(task);
        });
    }

    // Delete a task by ID
    public Optional<Task> deleteById(Long id) {
        return taskRepository.findById(id).map(task -> {
            taskRepository.deleteById(id);
            return task;
        });
    }
}
