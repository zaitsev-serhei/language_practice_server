package com.language_practice_server.server_demo.web.dto;

import com.language_practice_server.server_demo.common.enums.TaskDifficulty;
import com.language_practice_server.server_demo.common.enums.TaskType;
import jakarta.validation.constraints.NotNull;

public class TaskTemplateDto {
    private Long id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private TaskType taskType;
    @NotNull
    private TaskDifficulty difficulty;
    private String languageFrom;
    private String languageTo;
    //@NotNull
    private String instructions;
    //@NotNull
    private Long creatorId;
    private Long createdAt;

    public TaskTemplateDto() {
    }

    public TaskTemplateDto(Long id, @NotNull String title, String description, @NotNull TaskType taskType,
                           @NotNull TaskDifficulty difficulty, String languageFrom, String languageTo,
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
}
