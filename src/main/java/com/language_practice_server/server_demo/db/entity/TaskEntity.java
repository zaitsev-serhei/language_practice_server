package com.language_practice_server.server_demo.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long taskTemplateId;
    private Long creatorId;
    private Long createdAt;
    @Lob
    private String instructions;

    public TaskEntity() {
    }

    public TaskEntity(Long id, Long taskTemplateId, Long creatorId, Long createdAt) {
        this.id = id;
        this.taskTemplateId = taskTemplateId;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }

    public TaskEntity(Long id, Long taskTemplateId, Long creatorId, Long createdAt, String instructions) {
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
        TaskEntity that = (TaskEntity) o;
        if (getId() == null || that.getId() == null) return false;
        return getId().equals(that.getId());
    }

    //Це гарантує стабільність hashCode для транзієнтних об'єктів
    // (використовується identityHashCode) і коректне порівняння після персисту (id заданий).
    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", taskTemplateId=" + taskTemplateId +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                '}';
    }
}
