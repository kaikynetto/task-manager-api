package com.example.task.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateDto {
    private String name;
    private Boolean isFinished;
    private String description;
}