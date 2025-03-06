package com.seek.contexts.task.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false, updatable = false, name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

}
