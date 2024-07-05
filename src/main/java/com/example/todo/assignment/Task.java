package com.example.todo.assignment;

import com.example.todo.purchaser.ApplicationUser;
import com.example.todo.venture.Project;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Boolean completed;
    private String color; // Color representing urgency (e.g., "red", "yellow", "green")

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private ApplicationUser assignedTo;

    private LocalDate dueDate;

}
