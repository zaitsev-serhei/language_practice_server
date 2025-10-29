package com.language_practice_server.server_demo.service;

import com.language_practice_server.server_demo.domain.model.Task;
import com.language_practice_server.server_demo.domain.repository.TaskRepository;
import java.util.Optional;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Tag("service")
@SpringBootTest
@Transactional
public class TaskServiceIT {
    @Autowired
    private TaskService service;

    @Autowired
    private TaskRepository repository;


    @Test
    public void createTaskThrowsErrorWhenOwnerIdMissing() {
        Task task = new Task();
        task.setTaskTemplateId(1L);
        task.setInstructions("test");

        assertThrows(IllegalArgumentException.class, () -> service.createTask(task));
    }

    @Test
    public void createTaskThrowsErrorWhenTemplateIdMissing() {
        Task task = new Task();
        task.setOwnerId(1L);
        task.setInstructions("test");

        assertThrows(IllegalArgumentException.class, () -> service.createTask(task));
    }

    @Test
    public void createReturnsTaskWithId() {
        Task task = new Task();
        task.setOwnerId(1L);
        task.setTaskTemplateId(1L);
        task.setInstructions("test");

        Task saved = service.createTask(task);
        assertThat(saved.getId()).isNotNull();

    }

    @Test
    public void updateReturnsTaskWithUpdatedFields() {
        Task task = new Task(null, 1L, 1L, "test1");

        Task saved = service.createTask(task);
        saved.setOwnerId(2L);
        saved.setInstructions("test 2");

        Task updated = service.updateTask(saved);

        assertThat(updated.getOwnerId()).isEqualTo(saved.getOwnerId());
        assertThat(updated.getInstructions()).contains("test 2");
    }

    @Test
    public void findByIdReturnSavedTask() {
        Task task = new Task(null, 1L, 1L, "test1");

        Task saved = service.createTask(task);
        Task result = service.findTaskById(saved.getId());

        assertThat(result.getClass()).isNotNull();
        assertThat(result.getId()).isEqualTo(saved.getId());
        assertThat(result.getOwnerId()).isEqualTo(saved.getOwnerId());
        assertThat(result.getInstructions()).contains("test1");

        assertThat(result.getLastModifiedBy()).isNotNull();
        assertThat(result.getCreatedBy()).isNotNull();
    }

    @Test
    public void deleteMarksTaskAsDeleted() {
        Task task = new Task(null, 1L, 1L, "test1");

        Task saved = service.createTask(task);
        service.delete(saved.getId());

        Optional<Task> result = repository.findById(saved.getId());

        assertThat(result).isPresent();
        assertTrue(result.get().isDeleted());
    }

    @Test
    public void findByOwnerIdReturnsPageWithTasks() {
        Task task1 = new Task(null, 1L, 1L, "test1");
        Task task2 = new Task(null, 2L, 1L, "test1");
        Task task3 = new Task(null, 3L, 2L, "test1");
        service.createTask(task1);
        service.createTask(task2);
        service.createTask(task3);

        Page<Task> result = service.findAllTasksByOwnerId(1L, PageRequest.of(0, 10));

        assertThat(result.getContent()).isNotEmpty();
        assertThat(result.getContent()).allMatch(r -> r.getOwnerId().equals(1L));
        assertThat(result.getContent().size()).isEqualTo(2);
    }
}
