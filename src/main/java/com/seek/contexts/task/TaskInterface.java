package com.seek.contexts.task;

import com.seek.contexts.task.persistence.entities.Task;

import java.util.List;

public interface TaskInterface {
  List<Task> save(Task tasks);
  List<Task> delete(Long id);
  List<Task> getAll();
  Task getOneById(Long id);
}
