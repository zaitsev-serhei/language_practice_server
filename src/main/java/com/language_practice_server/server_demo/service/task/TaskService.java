package com.language_practice_server.server_demo.service.task;

import com.language_practice_server.server_demo.domain.model.Task;
import com.language_practice_server.server_demo.domain.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        if (task.getTaskTemplateId() == null) {
            throw new IllegalArgumentException("Task Template isn`t defined");
        }
        return taskRepository.saveTask(task);
    }

    public Task updateTask(Task task) {
        if (task.getTaskTemplateId() == null) {
            throw new IllegalArgumentException("Task Template isn`t defined");
        }
        return taskRepository.saveTask(task);
    }

    public void delete(Long taskId) {
        taskRepository.delete(taskId);
    }

    public Task findTaskById(Long taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task id isn`t defined");
        }
        return taskRepository.findById(taskId).orElseThrow();
    }

    public Page<Task> findAllTasksByCreatorId(Long creatorId, Pageable pageable) {
        if (creatorId == null) {
            throw new IllegalArgumentException("Task id isn`t defined");
        }
        return taskRepository.findAllTaskByCreatorId(creatorId, pageable);
    }
}
