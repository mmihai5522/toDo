package com.example.todo.venture;

import com.example.todo.assignment.Task;
import com.example.todo.purchaser.ApplicationUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String description;
    private String serviceType; // e.g., PREMIUM, SIMPLE

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    @ManyToMany
    @JoinTable(
            name = "project_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<ApplicationUser> owners;

    public Project(Builder builder){
        this.id= builder.id;
        this.name= builder.name;
        this.description= builder.description;
        this.serviceType= builder.serviceType;
        this.owners=builder.owners;
        this.tasks=builder.tasks;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String description;
        private String serviceType; // e.g., PREMIUM, SIMPLE
        private List<ApplicationUser> owners;
        private List<Task> tasks;

        public static Builder newInstance(){
            return new Builder();
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setServiceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        public Builder setOwner(List<ApplicationUser> owner) {
            this.owners = owner;
            return this;
        }

        public Builder setTasks(List<Task> tasks) {
            this.tasks = tasks;
            return this;
        }

        public Project build(){
            return new Project(this);
        }
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", owner=" + owners +
                ", tasks=" + tasks +
                '}';
    }
}
