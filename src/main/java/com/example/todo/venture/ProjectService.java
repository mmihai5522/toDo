package com.example.todo.venture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Get all users
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    // Get a project by ID
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow();
    }

    // Save a new project
    public Project save(Project project) {

        projectRepository.existsById(project.getId());

        System.out.println("Not a current project!");

        return projectRepository.save(project);
    }

    // Update an existing project
    public Optional<Project> update(Long id
            , Project projectDetails) {

        return projectRepository.findById(id)
                .map(project -> {
                    project.setId(projectDetails.getId());
                    project.setName(projectDetails.getName());
                    project.setDescription(projectDetails.getDescription());
                    project.setOwners(projectDetails.getOwners());
                    project.setServiceType(projectDetails.getServiceType());
                    project.setTasks(projectDetails.getTasks());
                    return projectRepository.save(project);
                });

    }
}
