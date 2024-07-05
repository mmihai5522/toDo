package com.example.todo.assignment.subtask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask,Long> {

    List<SubTask> findByTaskId(Long taskId);
}
