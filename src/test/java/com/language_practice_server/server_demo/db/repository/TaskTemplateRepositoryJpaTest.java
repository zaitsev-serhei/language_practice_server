package com.language_practice_server.server_demo.db.repository;

import com.language_practice_server.server_demo.db.entity.TaskTemplateEntity;
import com.language_practice_server.server_demo.common.enums.TaskType;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TaskTemplateRepositoryJpaTest {
    @Autowired
    private TaskTemplateRepositoryJpa repository;

    @Test
    public void findByCreatorIdReturnPage() {
        Long date = new Date().getTime();
        TaskTemplateEntity template1 = new TaskTemplateEntity(null, "Test 1", TaskType.TEST, 1L, date);
        TaskTemplateEntity template2 = new TaskTemplateEntity(null, "Test 2", TaskType.TEST, 1L, date);
        TaskTemplateEntity template3 = new TaskTemplateEntity(null, "Test 3", TaskType.TEST, 2L, date);

        repository.save(template1);
        repository.save(template2);
        repository.save(template3);

        Page<TaskTemplateEntity> result = repository.findByCreatorId(1L, PageRequest.of(0, 10));

        assertEquals(result.getTotalElements(), 2L);
        assertThat(result.getContent()).extracting(TaskTemplateEntity::getCreatorId).containsOnly(1L);
        assertThat(result.getContent()).extracting(TaskTemplateEntity::isDeleted).containsOnly(false);
    }
}
