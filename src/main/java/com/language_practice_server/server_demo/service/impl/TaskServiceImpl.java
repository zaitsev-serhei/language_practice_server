package com.language_practice_server.server_demo.service.impl;

import com.language_practice_server.server_demo.common.EventTopics;
import com.language_practice_server.server_demo.domain.model.Task;
import com.language_practice_server.server_demo.domain.repository.TaskRepository;
import com.language_practice_server.server_demo.kafka.KafkaEventProducer;
import com.language_practice_server.server_demo.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vavilonLearn.contracts.events.TaskCreatedEvent;

import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final KafkaEventProducer eventProducer;

    public TaskServiceImpl(TaskRepository taskRepository, KafkaEventProducer eventProducer) {
        this.taskRepository = taskRepository;
        this.eventProducer = eventProducer;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {
        if (task.getTaskTemplateId() == null || task.getOwnerId() == null) {
            throw new IllegalArgumentException("Task Template isn`t defined");
        }
        Task saved = taskRepository.saveTask(task);
        if(saved.getId()!=null){
            TaskCreatedEvent event = new TaskCreatedEvent(
                    UUID.randomUUID().toString(),
                    saved.getId().toString(),
                    saved.getOwnerId().toString(),
                    UUID.randomUUID().toString(),
                    "New Task",
                    "New Task description",
                    saved.getCreatedAt());
            System.out.println(event.toString());
            eventProducer.publish(EventTopics.TASK_CREATED,saved.getOwnerId().toString(),event);
        }
        return saved;
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
