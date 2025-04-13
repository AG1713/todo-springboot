package com.example.todo.models;

// Remember this is your table, i.e. it is the schema of the table when edited in the class
// and at the same time, it is used to constitute a row of information for the table using objects

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Lombok annotation. includes - @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
// Using this annotation, we save ourselves the boilerplate code for the getters and setters for this app
// This can be referred to as data class in Kotlin
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
