package com.example.task.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.domain.Task;

public interface TaskRepository extends JpaRepository<Task, UUID>{
    
}
