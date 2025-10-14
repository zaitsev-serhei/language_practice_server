package com.language_practice_server.server_demo.db.entity;

import com.language_practice_server.server_demo.domain.enums.TaskDifficulty;
import com.language_practice_server.server_demo.domain.enums.TaskType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "task_templates")
public class TaskTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;
    @Enumerated(EnumType.STRING)
    private TaskDifficulty difficulty;
    private String languageFrom;
    private String languageTo;
    @Lob
    private String instructions;
    private Long creatorId;
    private Long createdAt;

    public TaskTemplateEntity() {
    }

    public TaskTemplateEntity(Long id, String title, String description, TaskType taskType,
                              TaskDifficulty difficulty, Long creatorId, Long createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        this.difficulty = difficulty;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }

    public TaskTemplateEntity(Long id, String title, TaskType taskType, Long creatorId, Long createdAt) {
        this.id = id;
        this.title = title;
        this.taskType = taskType;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }

    public TaskTemplateEntity(Long id, String title, String description, TaskType taskType,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskTemplateEntity that = (TaskTemplateEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TaskTemplateEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskType=" + taskType +
                ", difficulty=" + difficulty +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                '}';
    }
}
