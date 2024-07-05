package com.example.todo.assignment.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Get all comments
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    // Get comments by task ID
    public List<Comment> findByTaskId(Long taskId) {
        return commentRepository.findByTaskId(taskId);
    }

    // Get comments by author ID
    public List<Comment> findByAuthorId(Long authorId) {
        return commentRepository.findByAuthor_UserId(authorId);
    }

    // Get a comment by ID
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    // Save a new comment
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    // Update an existing comment
    public Optional<Comment> update(Long id, Comment commentDetails) {
        return commentRepository.findById(id).map(comment -> {
            comment.setContent(commentDetails.getContent());
            comment.setAuthor(commentDetails.getAuthor());
            comment.setTask(commentDetails.getTask());
            comment.setCreatedDate(commentDetails.getCreatedDate());
            return commentRepository.save(comment);
        });
    }

    // Delete a comment by ID
    public Optional<Comment> deleteById(Long id) {
        return commentRepository.findById(id).map(comment -> {
            commentRepository.deleteById(id);
            return comment;
        });
    }
}
