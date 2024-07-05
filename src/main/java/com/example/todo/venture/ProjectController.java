package com.example.todo.venture;

import com.example.todo.purchaser.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    private ApplicationUser tempUser;
    Project tempProject=Project.Builder.newInstance()
            .setId(1L)
            .setName("AXION")
            .setOwner(List.of(
                    tempUser=ApplicationUser.Builder.newInstance()
                            .setUserId(1L)
                            .setUsername("mgm")
                            .setEmail("mgm@gmail.com")
                            .setRole("dev")
                            .setPassword("mgm")
                            .build()
                    ))
            .setDescription("Lorem ipsum")
            .setServiceType("regular")
            .build();

    //fetching all users
    @GetMapping("/all")
    public List<Project> getAllUsers(){
        return projectService.findAll();
    }


}
