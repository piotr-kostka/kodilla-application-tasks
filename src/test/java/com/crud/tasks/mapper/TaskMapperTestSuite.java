package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    private Task task;
    private TaskDto taskDto;
    private List<Task> taskList = new ArrayList<>();

    @BeforeEach
    void initData() {
        task = new Task(1L, "task1", "task1_desc");
        taskDto = new TaskDto(1L, "task1", "task1_desc");
        taskList.add(new Task(1L, "task_1", "task_1"));
        taskList.add(new Task(2L, "task_2", "task_2"));
    }

    @Test
    void mapToTaskTest() {
        //When
        Task expected = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, expected.getId());
        assertEquals("task1", expected.getTitle());
        assertEquals("task1_desc", expected.getContent());
    }

    @Test
    void mapToTaskDtoTest() {
        //When
        TaskDto expected = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, expected.getId());
        assertEquals("task1", expected.getTitle());
        assertEquals("task1_desc", expected.getContent());
    }

    @Test
    void mapToTaskDtoListTest() {
        //When
        List<TaskDto> expected = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(2, expected.size());
        assertThat(expected).isNotNull();
    }
}