package com.language_practice_server.server_demo.db.entity;

import java.util.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskEntityTest {
    @Test
    public void gettersAndSettersAndEquals() {
        Long date = new Date().getTime();
        TaskEntity task1 = new TaskEntity(1L, 1L, 100L, date, "instr");
        TaskEntity task2 = new TaskEntity(1L, 1L, 100L, date, "instr");
        TaskEntity task3 = new TaskEntity(2L, 4L, 300L, date, "instr");

        //getters
        assertEquals(1L, task1.getId());
        assertEquals(1L, task1.getTaskTemplateId());
        assertEquals(100L, task1.getCreatorId());
        assertEquals(date, task1.getCreatedAt());
        assertEquals("instr", task1.getInstructions());

        //equals
        assertEquals(task1, task2);
        assertNotEquals(task1, task3);
        assertNotEquals(task1.hashCode(), task3.hashCode());
        assertEquals(task1.hashCode(), task2.hashCode());

        //toString
        assertTrue(task1.toString().contains("TaskEntity"));
    }
    @Test
    public void equalsNullSafe(){
        TaskEntity task = new TaskEntity();
        task.setId(1L);

        assertNotEquals(task, null);
        assertNotEquals(task, new Object());
    }
}
