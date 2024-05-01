package br.com.victorbarros.curso_dev.modules.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorbarros.curso_dev.modules.courses.CourseEntity;
import br.com.victorbarros.curso_dev.modules.courses.CourseRepository;

@Service
public class ListCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity[] execute(String name, String category) {
    var courses = this.courseRepository.findAllByNameOrCategoryContainingIgnoreCase(
        name, category);

    return courses;
  }
}
