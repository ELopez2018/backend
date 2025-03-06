package com.seek.contexts.task;


import com.seek.contexts.task.persistence.entities.Task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRestController {

  @Autowired
  TaskService taskService;

  // Obtener todas las tareas
  @GetMapping
  public ResponseEntity<List<Task>> getAllTasks() {
    List<Task> tasks = taskService.getAll();
    return ResponseEntity.ok(tasks);
  }

  // Obtener una tarea por ID
  @GetMapping("/{id}")
  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
    Task task = taskService.getOneById(id);
    System.out.println(task.getDescription());
    return ResponseEntity.ok(task);
  }

  // Crear o actualizar las tareas y devuelve una lista
  @PostMapping
  public ResponseEntity<List<Task>> saveTasks(@RequestBody Task tasks) {
    List<Task> savedTasks = taskService.save(tasks);
    System.out.println(tasks.toString());
    return ResponseEntity.status(HttpStatus.CREATED).body(savedTasks);
  }

  // Eliminar una tarea por ID y devolver las restantes
  @DeleteMapping("/{id}")
  public ResponseEntity<List<Task>> deleteTask(@PathVariable Long id) {
    List<Task> remainingTasks = taskService.delete(id);
    return ResponseEntity.ok(remainingTasks);
  }
}
