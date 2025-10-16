package com.language_practice_server.server_demo.db.repository;

import com.language_practice_server.server_demo.db.entity.TaskEntity;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TaskRepositoryJpaTest {
    @Autowired
    private TaskRepositoryJpa repository;

    @Test
    public void findByCreatorIdReturnPage() {
        Long date = new Date().getTime();
        TaskEntity task1 = new TaskEntity(null, 1L, 100L, date, "instr");
        TaskEntity task2 = new TaskEntity(null, 1L, 100L, date, "instr");
        TaskEntity task3 = new TaskEntity(null, 4L, 300L, date, "instr");

        repository.save(task1);
        repository.save(task2);
        repository.save(task3);
        //when
        Page<TaskEntity> result = repository.findByCreatorId(100L, PageRequest.of(0, 10));

        //then
        assertEquals(result.getTotalElements(), 2L);
        assertThat(result.getContent()).extracting(TaskEntity::getCreatorId).containsOnly(100L);
    }
}
