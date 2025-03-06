package com.seek.contexts.task.persistence.repositories;

import com.seek.contexts.task.persistence.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
