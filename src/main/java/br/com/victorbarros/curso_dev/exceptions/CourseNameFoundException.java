package br.com.victorbarros.curso_dev.exceptions;

public class CourseNameFoundException extends RuntimeException {
  public CourseNameFoundException() {
    super("Nome do curso já está sendo utilizado");
  }
}
