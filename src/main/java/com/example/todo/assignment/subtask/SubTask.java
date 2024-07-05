package com.example.todo.assignment.subtask;

import com.example.todo.assignment.Task;
import com.example.todo.purchaser.ApplicationUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private ApplicationUser assignedTo;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    private LocalDate dueDate;


}
