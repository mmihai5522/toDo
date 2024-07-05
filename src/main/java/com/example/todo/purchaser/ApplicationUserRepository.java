package com.example.todo.purchaser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository
        extends JpaRepository<ApplicationUser,Long> {

}
