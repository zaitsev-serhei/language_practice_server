package com.language_practice_server.server_demo.service.impl;

import com.language_practice_server.server_demo.domain.model.Task;
import com.language_practice_server.server_demo.domain.repository.TaskRepository;
import com.language_practice_server.server_demo.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {
        if (task.getTaskTemplateId() == null || task.getOwnerId() == null) {
            throw new IllegalArgumentException("Task Template isn`t defined");
        }
        return taskRepository.saveTask(task);
    }

    @Override
    @Transactional
    public Task updateTask(Task task) {
        if (task.getTaskTemplateId() == null) {
            throw new IllegalArgumentException("Task Template isn`t defined");
        }
        return taskRepository.saveTask(task);
    }

    @Override
    @Transactional
    public void delete(Long taskId) {
        taskRepository.delete(taskId);
    }

    @Override
    @Transactional(readOnly = true)
    public Task findTaskById(Long taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task id isn`t defined");
        }
        return taskRepository.findById(taskId).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Task> findAllTasksByOwnerId(Long creatorId, Pageable pageable) {
        if (creatorId == null) {
            throw new IllegalArgumentException("Task id isn`t defined");
        }
        return taskRepository.findAllTaskByCreatorId(creatorId, pageable);
    }
}
