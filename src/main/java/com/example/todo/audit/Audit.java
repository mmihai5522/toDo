package com.example.todo.audit;

import com.example.todo.assignment.Task;
import com.example.todo.purchaser.ApplicationUser;
import com.example.todo.venture.Project;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;



}
