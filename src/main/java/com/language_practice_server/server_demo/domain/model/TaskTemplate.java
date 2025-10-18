package com.language_practice_server.server_demo.domain.model;

import com.language_practice_server.server_demo.domain.enums.TaskDifficulty;
import com.language_practice_server.server_demo.domain.enums.TaskType;

import java.util.Objects;

public class TaskTemplate {
    private Long id;
    private String title;
    private String description;
    private TaskType taskType;
    private TaskDifficulty difficulty;
    private String languageFrom;
    private String languageTo;
    private String instructions;
    private Long creatorId;
    private Long createdAt;
    private boolean isDeleted;

    public TaskTemplate() {
    }

    public TaskTemplate(Long id, String title, String description, TaskType taskType,
                        TaskDifficulty difficulty, Long creatorId, Long createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        this.difficulty = difficulty;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }

    public TaskTemplate(Long id, String title, String description, Long creatorId, Long createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }

    public TaskTemplate(Long id, String title, String description, TaskType taskType,
                        TaskDifficulty difficulty, String languageFrom, String languageTo,
                        String instructions, Long creatorId, Long createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        this.difficulty = difficulty;
        this.languageFrom = languageFrom;
        this.languageTo = languageTo;
        this.instructions = instructions;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public TaskDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(TaskDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getLanguageFrom() {
        return languageFrom;
    }

    public void setLanguageFrom(String languageFrom) {
        this.languageFrom = languageFrom;
    }

    public String getLanguageTo() {
        return languageTo;
    }

    public void setLanguageTo(String languageTo) {
        this.languageTo = languageTo;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskTemplate that = (TaskTemplate) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TaskTemplate{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskType=" + taskType +
                ", difficulty=" + difficulty +
                ", languageFrom='" + languageFrom + '\'' +
                ", languageTo='" + languageTo + '\'' +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                '}';
    }
}
