package br.com.victorbarros.curso_dev.modules.courses;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.victorbarros.curso_dev.types.Active;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "Course")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "Preencha o nome do curso.")
  private String name;

  @NotBlank(message = "Preencha a categoria do curso.")
  private String category;

  @Enumerated(EnumType.STRING)
  private Active active = Active.NO;

  @CreationTimestamp
  private LocalDateTime created_at;

  @UpdateTimestamp
  private String updated_at;
}
