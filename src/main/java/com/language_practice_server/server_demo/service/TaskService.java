package com.language_practice_server.server_demo.service;

import com.language_practice_server.server_demo.domain.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Task saveTask(Task task);

    Task updateTask(Task task);

    void delete(Long taskId);

    Task findTaskById(Long taskId);

    Page<Task> findAllTasksByCreatorId(Long creatorId, Pageable pageable);
}
