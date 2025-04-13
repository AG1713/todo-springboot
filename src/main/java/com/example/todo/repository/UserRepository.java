package com.example.todo.repository;

import com.example.todo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); // Tells spring boot to generate the query

}
