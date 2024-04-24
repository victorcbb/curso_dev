package br.com.victorbarros.curso_dev.modules.courses;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.victorbarros.curso_dev.types.Active;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Couse")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  private String category;

  @Enumerated
  private Active active;

  @CreationTimestamp
  private LocalDateTime created_at;

  @UpdateTimestamp
  private String updated_at;
}
