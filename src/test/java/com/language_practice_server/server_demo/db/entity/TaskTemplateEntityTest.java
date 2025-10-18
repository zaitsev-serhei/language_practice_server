package com.language_practice_server.server_demo.db.entity;

import java.util.Date;
import com.language_practice_server.server_demo.common.enums.TaskType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTemplateEntityTest {
    @Test
    public void gettersAndSettersAndEquals() {
        Long date = new Date().getTime();
        TaskTemplateEntity template1 = new TaskTemplateEntity(1L, "Test 1", TaskType.TEST, 1L, date);
        TaskTemplateEntity template2 = new TaskTemplateEntity(1L, "Test 1", TaskType.TEST, 1L, date);
        TaskTemplateEntity template3 = new TaskTemplateEntity(3L, "Test 2", TaskType.TEST, 1L, date);


        //getters
        assertEquals(1L, template1.getId());
        assertTrue(template1.getTitle().contains("Test 1"));
        assertEquals(TaskType.TEST, template1.getTaskType());
        assertEquals(1L, template1.getCreatorId());
        assertEquals(date, template1.getCreatedAt());

        //equals
        assertEquals(template1, template2);
        assertNotEquals(template1, template3);
        assertNotEquals(template1.hashCode(), template3.hashCode());
        assertEquals(template1.hashCode(), template2.hashCode());

        //toString
        assertTrue(template1.toString().contains("TaskTemplateEntity"));
    }

    @Test
    public void equalsNullSafe() {
        TaskTemplateEntity template = new TaskTemplateEntity();
        template.setId(1L);

        assertNotEquals(template, null);
        assertNotEquals(template, new Object());
    }
}
