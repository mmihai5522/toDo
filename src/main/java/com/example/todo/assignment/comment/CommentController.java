package com.example.todo.assignment.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RestController("api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Get comments by task ID
    @GetMapping("/task/{taskId}")
    public List<Comment> getCommentsByTaskId(@PathVariable Long taskId) {
        return commentService.findByTaskId(taskId);
    }

    // Get comments by author ID
    @GetMapping("/author/{authorId}")
    public List<Comment> getCommentsByAuthorId(@PathVariable Long authorId) {
        return commentService.findByAuthorId(authorId);
    }

    // Get a comment by ID
    @GetMapping("/fetch/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        return commentService.findById(id)
                .map(comment -> ResponseEntity.ok().body(comment))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a comment
    @PutMapping("/fetch comment/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id
            , @RequestBody Comment commentDetails) {
        return commentService.update(id, commentDetails)
                .map(updatedComment -> ResponseEntity.ok().body(updatedComment))
                .orElse(ResponseEntity.notFound().build());
    }

}
