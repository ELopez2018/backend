package com.seek.contexts.task;

import com.seek.contexts.task.persistence.entities.Task;
import com.seek.contexts.task.persistence.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class TaskServiceTest {

  @Mock
  private TaskRepository taskRepository;

  @InjectMocks
  private TaskService taskService;


  private Task task;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    task = new Task();
    task.setId(1L);
    task.setDescription("Description");
    task.setTitle("title");
    task.setStatus("Por Hacer");
  }

  @Test
  void save() {
    when(taskService.save(task)).thenReturn(Arrays.asList(task));
    assertNotNull(taskService.save(task));
  }

  @Test
  void delete() {
    doNothing().when(taskRepository).deleteById(task.getId());
    when(taskRepository.existsById(task.getId())).thenReturn(true);
    when(taskService.delete(task.getId())).thenReturn(Arrays.asList(task));
    assertNotNull(taskService.delete(task.getId()));
  }

  @Test
  void getAll() {
    when(taskService.getAll()).thenReturn(Arrays.asList(task));
    assertNotNull(taskService.getAll());
  }

  @Test
  void getOneById() {
    when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));
    assertNotNull(taskService.getOneById(task.getId()));
  }
}