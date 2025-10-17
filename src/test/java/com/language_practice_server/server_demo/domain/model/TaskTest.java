package com.language_practice_server.server_demo.domain.model;

import java.util.Date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    @Test
    public void gettersAndSetterAndEquals() {
        Long date = new Date().getTime();
        Task task1 = new Task(1L, 100L, 200L, date, "instr");
        Task task2 = new Task(1L, 100L, 200L, date, "instr");
        Task task3 = new Task(2L, 200L, 300L, date, "instr");

        //getters
        assertEquals(1L, task1.getId());
        assertEquals(100L, task1.getTaskTemplateId());
        assertEquals(200L, task1.getCreatorId());
        assertEquals(date, task1.getCreatedAt());
        assertTrue(task1.getInstructions().contains("instr"));

        //equals
        assertEquals(task1, task2);
        assertNotEquals(task1, task3);
        assertEquals(task1.hashCode(), task2.hashCode());
        assertNotEquals(task1.hashCode(), task3.hashCode());

        //toString()
        assertTrue(task1.toString().contains("Task"));
    }

    @Test
    public void equalsNullSafe() {
        Task task = new Task();
        task.setId(1L);

        assertNotEquals(task, null);
        assertNotEquals(task, new Object());
    }
}
