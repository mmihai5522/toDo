package com.example.todo.assignment.subtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubTaskService {

    @Autowired
    private SubTaskRepository subTaskRepository;

    // Get all subtasks for a given task
    public List<SubTask> findAllByTaskId(Long taskId) {
        return subTaskRepository.findByTaskId(taskId);
    }

    // Get a subtask by ID
    public Optional<SubTask> findById(Long id) {
        return subTaskRepository.findById(id);
    }

    // Save a new subtask
    public SubTask save(SubTask subtask) {
        return subTaskRepository.save(subtask);
    }

    // Update an existing subtask
    public Optional<SubTask> update(Long id, SubTask subtaskDetails) {
        return subTaskRepository.findById(id).map(subtask -> {
            subtask.setTitle(subtaskDetails.getTitle());
            subtask.setDescription(subtaskDetails.getDescription());
            subtask.setCompleted(subtaskDetails.isCompleted());
            subtask.setTask(subtaskDetails.getTask());
            return subTaskRepository.save(subtask);
        });
    }
}
