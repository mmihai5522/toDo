package com.example.todo.purchaser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/users")
public class ApplicationUserController {

    @Autowired
    ApplicationUserService userService;

    //fetching all users
    @GetMapping("/all")
    public List<ApplicationUser> getAllUsers(){
        return userService.findAll();
    }

    //fetching a certain user
    @GetMapping("/fetching/{id}")
    public ResponseEntity<ApplicationUser> fetchRegularEntity(
            @PathVariable Long id) {

        ApplicationUser fetchedUser=
                 userService.findById(id);

        return new ResponseEntity<>(fetchedUser, OK);
    }

    //create a new user
    @PostMapping("/generate")
    public ResponseEntity<ApplicationUser> createUser(
            @RequestBody ApplicationUser user) {
        return new ResponseEntity<>(userService.save(user),OK);
    }

    //update a user
    @PutMapping("/revise/{id}")
    public ResponseEntity<Optional<ApplicationUser>> updateUser(
            @PathVariable Long id, @RequestBody ApplicationUser userDetails) {

        Optional<ApplicationUser> revisedUser = userService.update(
                userDetails.getUserId(),userDetails);

            return ResponseEntity.ok(revisedUser);
    }

}
