package com.language_practice_server.server_demo.service.task;

import com.language_practice_server.server_demo.domain.model.TaskTemplate;
import com.language_practice_server.server_demo.domain.repository.TaskTemplateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskTemplateService {
    private final TaskTemplateRepository templateRepository;

    public TaskTemplateService(TaskTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public TaskTemplate createTemplate(TaskTemplate template) {
        if (template.getTitle() == null || template.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        return templateRepository.save(template);
    }

    public TaskTemplate findTemplateById(Long templateId) {
        return templateRepository.findTaskTemplateById(templateId).orElseThrow();
    }

    public TaskTemplate updateTemplate(TaskTemplate template) {
        if (template.getTitle() == null || template.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        return templateRepository.save(template);
    }

    public void deleteTemplate(Long templateId) {
        templateRepository.delete(templateId);
    }

    public Page<TaskTemplate> findAllTaskTemplateByCreatorId(Long creatorId, Pageable pageable) {
        return templateRepository.findAllTaskTemplateByCreatorId(creatorId, pageable);
    }
}
