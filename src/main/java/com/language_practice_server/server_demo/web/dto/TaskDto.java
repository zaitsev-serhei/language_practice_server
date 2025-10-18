package com.language_practice_server.server_demo.web.dto;

import jakarta.validation.constraints.NotNull;

public class TaskDto {
    private Long id;
    @NotNull
    private Long taskTemplateId;
    @NotNull
    private Long creatorId;
    private Long createdAt;
    //@NotNull
    private String instructions;

    public TaskDto(){

    }

    public TaskDto(Long id, @NotNull Long taskTemplateId, @NotNull Long creatorId, Long createdAt, String instructions) {
        this.id = id;
        this.taskTemplateId = taskTemplateId;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskTemplateId() {
        return taskTemplateId;
    }

    public void setTaskTemplateId(Long taskTemplateId) {
        this.taskTemplateId = taskTemplateId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
