package com.seek.contexts.task;

import com.seek.contexts.task.persistence.entities.Task;
import com.seek.contexts.task.persistence.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskService implements TaskInterface {

  @Autowired
  TaskRepository taskRepository;

  @Override
  public List<Task> save(Task tasks) {
    taskRepository.saveAndFlush(tasks);
    return  taskRepository.findAll();
  }

  @Override
  public List<Task> delete(Long id) {
    if (!taskRepository.existsById(id)) {
      throw new EntityNotFoundException("Task con ID " + id + " no encontrada.");
    }
    taskRepository.deleteById(id);
    return taskRepository.findAll();
  }

  @Override
  public List<Task> getAll() {
    return taskRepository.findAll();
  }

  @Override
  public Task getOneById(Long id) {
    return taskRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Task con ID " + id + " no encontrada."));
  }


}
