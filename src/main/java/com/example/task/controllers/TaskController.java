package com.example.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.domain.dto.TaskCreateDto;
import com.example.task.domain.dto.TaskDto;
import com.example.task.domain.dto.TaskUpdateDto;
import com.example.task.domain.service.TaskService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService service;
    
    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<TaskDto> tasks = service.getAll();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody TaskCreateDto taskCreateDto) {
        TaskDto taskDto = service.create(taskCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
    }

     @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody TaskUpdateDto taskUpdateDto) {

        try {
            service.update(id, taskUpdateDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
