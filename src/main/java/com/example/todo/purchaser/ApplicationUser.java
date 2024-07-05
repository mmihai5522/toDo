package com.example.todo.purchaser;

import com.example.todo.venture.Project;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;

@Entity
public class ApplicationUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String username;
    private String password;
    private String email;
    private String role;

    @ManyToMany(mappedBy = "owners")
    private List<Project> projects;

    public ApplicationUser() {}

    public ApplicationUser(Builder builder){
        this.userId= builder.userId;
        this.username= builder.username;
        this.password= builder.password;
        this.email= builder.email;
        this.role=builder.role;
        this.projects=builder.projects;
    }

    public static class Builder{

        public static Builder newInstance(){
            return new Builder();
        }

        private Long userId;
        private String username;
        private String password;
        private String email;
        private String role;
        private List<Project> projects;

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setProjects(List<Project> projects) {
            this.projects = projects;
            return this;
        }

        public ApplicationUser build(){
            return new ApplicationUser(this);
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
