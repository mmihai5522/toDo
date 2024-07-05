package com.example.todo.purchaser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserService{

    @Autowired
    private ApplicationUserRepository userRepository;

    // Get all users
    public List<ApplicationUser> findAll() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public ApplicationUser findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    // Save a new user
    public ApplicationUser save(ApplicationUser user) {

        userRepository.existsById(user.getUserId());

        System.out.println("Not a user!");

        return userRepository.save(user);
    }

    // Update an existing user
    public Optional<ApplicationUser> update(Long id
            , ApplicationUser userDetails) {

        return userRepository.findById(id)
                .map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        });

    }
}
