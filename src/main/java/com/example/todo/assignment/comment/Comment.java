package com.example.todo.assignment.comment;
import com.example.todo.assignment.Task;
import com.example.todo.purchaser.ApplicationUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser author;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private LocalDateTime createdDate;
}
