package com.language_practice_server.server_demo.domain.model;

import java.util.Objects;

public class Task {
    private Long id;
    private Long taskTemplateId;
    private Long creatorId;
    private Long createdAt;
    private String instructions;

    public Task() {
    }

    public Task(Long id, Long taskTemplateId, Long creatorId, Long createdAt, String instructions) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getId().equals(task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskTemplateId=" + taskTemplateId +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                '}';
    }
}
