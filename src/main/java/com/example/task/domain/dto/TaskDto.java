package com.example.task.domain.dto;

import java.util.UUID;

import com.example.task.domain.Task;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

    
        public TaskDto(Task task) {
            this.id = task.getId();
            this.name = task.getName();
            this.description = task.getDescription();
            this.isFinished = task.getIsFinished();
        };
private UUID id;

    private String name;

    private String description;

    private Boolean isFinished = false;
}
