package com.example.task.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.domain.Task;
import com.example.task.domain.dto.TaskCreateDto;
import com.example.task.domain.dto.TaskDto;
import com.example.task.domain.dto.TaskUpdateDto;
import com.example.task.domain.repository.TaskRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public TaskDto create(TaskCreateDto taskCreateDto) {
        Task newTask = new Task();
        BeanUtils.copyProperties(taskCreateDto, newTask);

        repository.save(newTask);

        return new TaskDto(newTask);
    }

    public List<TaskDto> getAll() {
        return repository.findAll().stream().map(TaskDto::new).toList();
    }

     public void update(UUID id, TaskUpdateDto taskUpdateDto) throws Exception {
        Optional<Task> taskOptional = repository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setIsFinished(true);

            repository.save(task);
        } else {
            throw new Exception("Book not found");
        }
    }
}
