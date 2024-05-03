package br.com.victorbarros.curso_dev.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Curso não encontrado");
  }
}
