package com.language_practice_server.server_demo.domain.repository.impl;

import com.language_practice_server.server_demo.db.entity.TaskTemplateEntity;
import com.language_practice_server.server_demo.db.repository.TaskTemplateRepositoryJpa;
import com.language_practice_server.server_demo.domain.model.TaskTemplate;
import com.language_practice_server.server_demo.domain.repository.TaskTemplateRepository;
import com.language_practice_server.server_demo.mapper.TaskTemplateMapper;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public class TaskTemplateRepositoryImpl implements TaskTemplateRepository {
    private final TaskTemplateRepositoryJpa repositoryJpa;
    private final TaskTemplateMapper templateMapper;

    public TaskTemplateRepositoryImpl(TaskTemplateRepositoryJpa repositoryJpa,
                                      TaskTemplateMapper mapper) {
        this.repositoryJpa = repositoryJpa;
        this.templateMapper = mapper;
    }

    @Override
    public TaskTemplate save(TaskTemplate template) {
        TaskTemplateEntity entity = templateMapper.toEntity(template);
        return templateMapper.toDomain(repositoryJpa.save(entity));
    }

    @Override
    public TaskTemplate update(TaskTemplate template) {
        TaskTemplateEntity entity = templateMapper.toEntity(template);
        return templateMapper.toDomain(repositoryJpa.save(entity));
    }

    @Override
    public void delete(Long templateId) {
        repositoryJpa.deleteById(templateId);
    }

    @Override
    public Optional<TaskTemplate> findTaskTemplateById(Long templateId) {
        return repositoryJpa.findById(templateId).map(templateMapper::toDomain);
    }

    @Override
    public Page<TaskTemplate> findAllTaskTemplateByCreatorId(Long creatorId, Pageable pageable) {
        return repositoryJpa.findByCreatorId(creatorId, pageable).map(templateMapper::toDomain);
    }
}
