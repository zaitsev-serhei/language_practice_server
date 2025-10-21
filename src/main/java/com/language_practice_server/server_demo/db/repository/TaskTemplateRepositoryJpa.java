package com.language_practice_server.server_demo.db.repository;

import com.language_practice_server.server_demo.db.entity.TaskTemplateEntity;
import com.language_practice_server.server_demo.domain.model.TaskTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTemplateRepositoryJpa extends JpaRepository<TaskTemplateEntity, Long> {
    Page<TaskTemplateEntity> findByCreatorId(Long creatorId, Pageable page);

    Page<TaskTemplate> findByCreatorIdAndDeletedFalse(Long creatorId, Pageable page);
}
